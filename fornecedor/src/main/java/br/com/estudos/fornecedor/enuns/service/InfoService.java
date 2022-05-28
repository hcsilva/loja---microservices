package br.com.estudos.fornecedor.enuns.service;

import br.com.estudos.fornecedor.model.InfoFornecedor;
import br.com.estudos.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoByEstado(String estado) {
        return infoRepository.findByEstado(estado);
    }
}
