package br.com.estudos.fornecedor.controller;

import br.com.estudos.fornecedor.model.InfoFornecedor;
import br.com.estudos.fornecedor.enuns.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InfoController {
    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @GetMapping("/{estado}")
    public InfoFornecedor getInfoByState(@PathVariable(value = "estado") String estado) {
        LOG.info("Recebido pedido de informações do fornecedor de {}", estado);
        return infoService.getInfoByEstado(estado);
    }


}
