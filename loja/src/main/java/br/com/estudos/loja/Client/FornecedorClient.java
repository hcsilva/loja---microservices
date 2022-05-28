package br.com.estudos.loja.Client;

import br.com.estudos.loja.dto.InfoPedidoDTO;
import br.com.estudos.loja.dto.InforFornecedorDTO;
import br.com.estudos.loja.dto.ItemCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InforFornecedorDTO getInfoByEstado(@PathVariable(value = "estado") String estado);

    @PostMapping("/pedido")
    InfoPedidoDTO realizaPedido(List<ItemCompraDTO> itens);
}
