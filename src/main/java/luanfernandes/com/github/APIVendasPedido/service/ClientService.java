package luanfernandes.com.github.APIVendasPedido.service;

import ch.qos.logback.core.net.server.Client;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Cliente;
import luanfernandes.com.github.APIVendasPedido.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Cliente inserirclient(Cliente cliente){
        cliente.setId(null);
        return clientRepository.save(cliente);
    }


}
