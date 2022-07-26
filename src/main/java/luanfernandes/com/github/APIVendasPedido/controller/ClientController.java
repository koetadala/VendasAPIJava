package luanfernandes.com.github.APIVendasPedido.controller;


import luanfernandes.com.github.APIVendasPedido.controller.api.ClienteApi;
import luanfernandes.com.github.APIVendasPedido.domain.dto.ClienteDto;
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
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController implements ClienteApi {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente){
        clientService.inserirclient(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
     public <clienteDto> ResponseEntity<Void> updateCliente(@PathVariable Integer id, @Valid @RequestBody ClienteDto clientedto){
        Cliente cliente = clientService.fromDto(clientedto);
        cliente.setId(id);
        clientService.updateCliente(cliente);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findCliente(@PathVariable Integer id){
        Cliente cliente = clientService.find(id);
        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(value = "/{id}", method =  RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id){
        clientService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }


}
