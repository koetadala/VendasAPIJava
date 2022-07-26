package luanfernandes.com.github.APIVendasPedido.service;

import luanfernandes.com.github.APIVendasPedido.controller.exception.ObjectNotFoundException;
import luanfernandes.com.github.APIVendasPedido.domain.dto.ClienteDto;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Cliente;
import luanfernandes.com.github.APIVendasPedido.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Cliente inserirclient(Cliente cliente){
        return clientRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente){
        Cliente clienteToUpdate = find(cliente.getId());
        updateData(clienteToUpdate, cliente);
        return clientRepository.save(clienteToUpdate);
    }

    public void updateData(Cliente clienteToUpdate, Cliente cliente) {
        clienteToUpdate.setNome(cliente.getNome());
        clienteToUpdate.setEmail(cliente.getEmail());
        clienteToUpdate.setTelefone(cliente.getTelefone());

    }

    public Cliente find(Integer id) {
       Optional<Cliente>cliente = clientRepository.findById(id);
       return cliente.orElseThrow(()-> new ObjectNotFoundException("Cliente não Encontrado "+ id +", tipo: "
               + Cliente.class.getName()));
    }

    public Cliente fromDto(ClienteDto clientedto) {
        return new  Cliente(clientedto.getId(), clientedto.getNome(), clientedto.getEmail(), clientedto.getTelefone(),
       null, null);
    }

    public void deleteCliente(Integer id) {
        find(id);
        try {
           clientRepository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não e Possivel Excluir um Cliente com Dados Vinculados");
        }
    }

    public List<Cliente> findAll(){
        return clientRepository.findAll();
    }


}

