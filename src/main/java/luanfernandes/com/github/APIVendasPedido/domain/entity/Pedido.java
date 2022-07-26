package luanfernandes.com.github.APIVendasPedido.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import luanfernandes.com.github.APIVendasPedido.domain.enums.StatusPedido;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "pedido")
    public class Pedido{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
        private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;


    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;

    @Column(name = "status_pedido")
    private StatusPedido statusPedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;



}
