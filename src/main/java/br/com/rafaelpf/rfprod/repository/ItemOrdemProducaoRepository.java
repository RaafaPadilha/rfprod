package br.com.rafaelpf.rfprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.ItemOrdemProducao;

@Repository
public interface ItemOrdemProducaoRepository extends CrudRepository<ItemOrdemProducao, Long> {

	@Query (
		value = "SELECT * FROM item_ordem_producao AS iop WHERE iop.id_ordem_producao = ?1",
		nativeQuery = true
	)
	List<ItemOrdemProducao> findItemOrdemProducaoByOrderProducaoId(Long idOrdemProducao);

}
