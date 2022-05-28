package br.com.estudos.fornecedor.controller;


import br.com.estudos.fornecedor.dto.ItemPedidoDTO;
import br.com.estudos.fornecedor.enuns.service.PedidoService;
import br.com.estudos.fornecedor.model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido realizaPedido(@RequestBody List<ItemPedidoDTO> produtos) {
        LOG.info("Pedido Recebido");
        return pedidoService.realizaPedido(produtos);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable(value = "id") Long id) {
        return pedidoService.getPedidoPorId(id);
    }

}
