package br.com.rafaelpf.rfprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.ItemOrdemProducao;

@Repository
public interface ItemOrdemProducaoRepository extends CrudRepository<ItemOrdemProducao, Long> {

	@Query (
		value = "SELECT * FROM ITEM_ORDEM_PRODUCAO AS IOP WHERE IOP.ID_ORDEM_PRODUCAO = ?1",
		nativeQuery = true
	)
	List<ItemOrdemProducao> findItemOrdemProducaoByOrderProducaoId(Long idOrdemProducao);

}
