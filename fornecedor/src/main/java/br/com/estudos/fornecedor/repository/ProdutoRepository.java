package br.com.estudos.fornecedor.repository;

import br.com.estudos.fornecedor.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByEstado(String estado);

    List<Produto> findByIdIn(List<Long> ids);

}
