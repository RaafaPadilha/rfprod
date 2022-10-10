package br.com.rafaelpf.rfprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.Apontamento;

@Repository
public interface ApontamentoRepository extends CrudRepository<Apontamento, Long> {

	@Query (
		value = "SELECT * FROM apontamento AS p WHERE p.id_ordem_producao = ?1",
		nativeQuery = true
	)
	List<Apontamento> findApontamentoByOrderProducaoId(Long idOrdemProducao);

}
