package luanfernandes.com.github.APIVendasPedido.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_pedido")

public class ItemPedido {

    public Integer getProduto;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

   @ManyToOne
   @JoinColumn(name = "pedido_id")
    private Pedido pedido;

   @Column(name = "quantidade")
    private  Integer quantidade;


}






