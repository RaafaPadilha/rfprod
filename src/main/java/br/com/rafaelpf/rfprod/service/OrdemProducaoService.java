package br.com.rafaelpf.rfprod.service;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.OrdemProducao;

public interface OrdemProducaoService {

	List<OrdemProducao> todasOrdensProducao();

	Optional<OrdemProducao> ordemProducaoPorId(Long id);

	OrdemProducao novaOrdemProducao(OrdemProducao ordemProducao);

	Integer quantidadeOrdemProducao();

	// Uma Ordem de Produção não pode ser excluida

}
