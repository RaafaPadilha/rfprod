package br.com.rafaelpf.rfprod.service;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.Processo;

public interface ProcessoService {

	List<Processo> todosProcessos();

	Optional<Processo> processoPorId(Long id);

	Processo novoProcesso(Processo processo);

	void excluirProcesso(Long id);

}
