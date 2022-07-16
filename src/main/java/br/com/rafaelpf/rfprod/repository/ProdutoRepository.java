package br.com.rafaelpf.rfprod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
