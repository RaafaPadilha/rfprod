package br.com.rafaelpf.rfprod.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	@Query(value = "SELECT COUNT(id) FROM FUNCIONARIO", nativeQuery = true)
	Integer countFuncionario();

}
