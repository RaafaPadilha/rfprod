package br.com.rafaelpf.rfprod.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.Maquina;

@Repository
public interface MaquinaRepository extends CrudRepository<Maquina, Long> {

	@Query(
		value = "SELECT COUNT(id) FROM maquina",
		nativeQuery = true
	)
	Integer countMaquina();

}
