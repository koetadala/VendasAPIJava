package luanfernandes.com.github.APIVendasPedido.controller;


import luanfernandes.com.github.APIVendasPedido.domain.entity.Cliente;
import luanfernandes.com.github.APIVendasPedido.repository.ClientRepository;
import luanfernandes.com.github.APIVendasPedido.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClientContorller {

    @Autowired
    private ClientRepository clientRepository;

    private ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente){
        clientService.inserirclient(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
