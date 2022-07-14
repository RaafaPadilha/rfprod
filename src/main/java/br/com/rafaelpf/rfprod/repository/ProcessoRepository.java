package br.com.rafaelpf.rfprod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelpf.rfprod.model.Processo;

@Repository
public interface ProcessoRepository extends CrudRepository<Processo, Long> {

}