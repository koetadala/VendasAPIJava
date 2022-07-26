package luanfernandes.com.github.APIVendasPedido.repository;

import luanfernandes.com.github.APIVendasPedido.domain.entity.ItemPedido;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
