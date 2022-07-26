package luanfernandes.com.github.APIVendasPedido.controller;

import luanfernandes.com.github.APIVendasPedido.domain.dto.PedidoDto;
import luanfernandes.com.github.APIVendasPedido.domain.entity.Pedido;
import luanfernandes.com.github.APIVendasPedido.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer inlcuirPedido(@RequestBody @Valid PedidoDto pedidoDto){
        Pedido pedido = PedidoService.incluirPedido(pedidoDto);
        return Pedido.getId();
    }


}
