package luanfernandes.com.github.APIVendasPedido.controller;


import luanfernandes.com.github.APIVendasPedido.domain.dto.ProdutoDto;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Produto;
import luanfernandes.com.github.APIVendasPedido.repository.ProdutoRepository;
import luanfernandes.com.github.APIVendasPedido.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    private ProdutoService produtoService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirProduto(@RequestBody @Valid Produto produto) {
        produtoService.inserirProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public <produtoDto> ResponseEntity<Void> updatproduto(@PathVariable Integer id, @Valid @RequestBody ProdutoDto produtodto) {
        Produto produto = produtoService.fromDto(produtodto);
        produto.setId(id);
        produtoService.updateProduto(produto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> findProduto(@PathVariable Integer id) {
        Produto produto = produtoService.find(id);
        return ResponseEntity.ok().body(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

}
