package br.com.rafaelpf.rfprod.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.OrdemProducao;

@Repository
public interface ordemProducaoRepository extends CrudRepository<OrdemProducao, Long> {

	@Query(value = "SELECT COUNT(*) FROM ORDEM_PRODUCAO", nativeQuery = true)
	Integer countOrdemProducao();

}
