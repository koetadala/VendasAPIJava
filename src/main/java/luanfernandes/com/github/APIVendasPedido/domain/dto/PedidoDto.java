package luanfernandes.com.github.APIVendasPedido.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import luanfernandes.com.github.APIVendasPedido.anotations.NotEmptyList;
import luanfernandes.com.github.APIVendasPedido.domain.entity.ItemPedido;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {

    @NotNull(message = "Informe p cliente o código do cliente")
    private Integer cliente;

    @NotNull(message = "campo total do pedido é obirgatorio")
    private BigDecimal total;


    @NotEmptyList(mesage = "pedido não pode ser realizado sem itens")
    private List<ItemPedido> itens;

}
