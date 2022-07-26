package luanfernandes.com.github.APIVendasPedido.service;

import lombok.RequiredArgsConstructor;
import luanfernandes.com.github.APIVendasPedido.controller.exception.RegraDeNegocioExeption;
import luanfernandes.com.github.APIVendasPedido.domain.dto.PedidoDto;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Cliente;
import luanfernandes.com.github.APIVendasPedido.domain.entity.ItemPedido;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Pedido;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Produto;
import luanfernandes.com.github.APIVendasPedido.domain.enums.StatusPedido;
import luanfernandes.com.github.APIVendasPedido.repository.ClientRepository;
import luanfernandes.com.github.APIVendasPedido.repository.ItemPedidoRepository;
import luanfernandes.com.github.APIVendasPedido.repository.PedidoRepository;
import luanfernandes.com.github.APIVendasPedido.repository.ProdutoRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Nodes.collect;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private static ClientRepository clientRepository;
    @Autowired
    private final PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private static ProdutoRepository produtoRepository;


    public static Pedido incluirPedido(PedidoDto pedidoDto) {

        //MOntar os itens do pedido
        validarItens(pedidoDto);
        //Encontrar o Cliente
        Cliente cliente = findeCliente(pedidoDto);

        Pedido pedido = builderPedido(pedidoDto, cliente);

        List<ItemPedido> itens = builderItemPedido(pedidoDto, pedido);
    }



    private static Pedido builderPedido(PedidoDto pedidoDto, Cliente cliente) {
        return Pedido.builder()
                .cliente(cliente)
                .dataPedido(LocalDate.now())
                .total(pedidoDto.getTotal())
                .statusPedido(StatusPedido.ABERTO)
                .build();
    }

    private static Cliente findeCliente(PedidoDto pedidoDto) {
        return clientRepository.findById(pedidoDto.getCliente())
                .orElseThrow(()-> new RegraDeNegocioExeption("codigo do cliente invalido"));
    }

    private static void validarItens(PedidoDto pedidoDto) {
        if (pedidoDto.getItens().isEmpty()){
            throw new RegraDeNegocioExeption("Não e possivel realizar um pedido sem itens");
        }
    }


}

