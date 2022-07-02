package luanfernandes.com.github.APIVendasPedido.repository;

import ch.qos.logback.core.net.server.Client;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente,Integer> {

}
