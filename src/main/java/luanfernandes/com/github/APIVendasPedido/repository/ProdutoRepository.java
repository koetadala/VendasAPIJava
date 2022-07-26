package luanfernandes.com.github.APIVendasPedido.repository;

import luanfernandes.com.github.APIVendasPedido.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

}