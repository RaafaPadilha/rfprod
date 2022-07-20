package br.com.rafaelpf.rfprod.service;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.Apontamento;

public interface ApontamentoService {

	List<Apontamento> apontamentoPorIdOrdemProducao(Long idOrdemProducao);

	Optional<Apontamento> apontamentoPorId(Long id);

	Apontamento novoApontamento(Apontamento apontamento);

	void excluirApontamento(Long id);

}
