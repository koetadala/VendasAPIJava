package luanfernandes.com.github.APIVendasPedido.controller.api;

import luanfernandes.com.github.APIVendasPedido.domain.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ClienteApi {

   public ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente);
   // public ResponseEntity<Void> atualizaCliente();
   // public ResponseEntity<Void> buscaCliente();
   // public ResponseEntity<Void> deletaCliente();


}
