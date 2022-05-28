package br.com.estudos.loja.service;

import br.com.estudos.loja.Client.FornecedorClient;
import br.com.estudos.loja.dto.CompraDTO;
import br.com.estudos.loja.dto.InfoPedidoDTO;
import br.com.estudos.loja.dto.InforFornecedorDTO;
import br.com.estudos.loja.modelo.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {
    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private RestTemplate client;

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    //Forma Antiga
/*    public void realizaCompra(CompraDTO compra) {
        RestTemplate client = new RestTemplate();
        ResponseEntity<InforFornecedorDTO> exchange =
                client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
                HttpMethod.GET, null, InforFornecedorDTO.class);


        System.out.println(exchange.getBody().getEndereco());
    }*/

    //Forma Antiga versão 2
/*    public void realizaCompra(CompraDTO compra) {
        ResponseEntity<InforFornecedorDTO> exchange =
                client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
                        HttpMethod.GET, null, InforFornecedorDTO.class);


        System.out.println(exchange.getBody().getEndereco());
    }*/

    public Compra realizaCompra(CompraDTO compra) {

        LOG.info("Buscando informações do fornecedor de {}", compra.getEndereco().getEstado());

        InforFornecedorDTO info = fornecedorClient.getInfoByEstado(compra.getEndereco().getEstado());
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

        LOG.info("Realizando um pedido");
        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        return compraSalva;
    }
}