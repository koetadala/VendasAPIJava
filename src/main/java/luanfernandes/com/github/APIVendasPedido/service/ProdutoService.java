package luanfernandes.com.github.APIVendasPedido.service;

import luanfernandes.com.github.APIVendasPedido.controller.exception.ObjectNotFoundException;
import luanfernandes.com.github.APIVendasPedido.domain.dto.ProdutoDto;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Produto;
import luanfernandes.com.github.APIVendasPedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto inserirProduto(Produto produto){
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Produto produto){
        Produto produtoToUpdate = find(produto.getId());
        updateData(produtoToUpdate, produto);
        return produtoRepository.save(produtoToUpdate);
    }

    public void updateData(Produto produtoToUpadete, Produto produto) {
        produtoToUpadete.setTitulo(produto.getTitulo());
        produtoToUpadete.setPreco(produto.getPreco());

    }

    public Produto find(Integer id) {
       Optional<Produto>produto = produtoRepository.findById(id);
       return produto.orElseThrow(()-> new ObjectNotFoundException("Produto não Encontrado "+ id +", tipo: "
               + Produto.class.getName()));
    }

    public Produto fromDto(ProdutoDto produtoDto) {
        return new  Produto(produtoDto.getId(), produtoDto.getTitulo(), produtoDto.getPreco());
    }

    public void deleteProduto(Integer id) {
        find(id);
        try {
           produtoRepository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não e Possivel Excluir um Produto com Dados Vinculados");
        }
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }



}

