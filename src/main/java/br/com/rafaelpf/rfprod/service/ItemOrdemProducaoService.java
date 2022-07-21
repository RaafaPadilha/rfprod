package br.com.rafaelpf.rfprod.service;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.ItemOrdemProducao;

public interface ItemOrdemProducaoService {

	List<ItemOrdemProducao> itemOrdemProducaoPorIdOrdemProducao(Long idOrdemProducao);

	Optional<ItemOrdemProducao> itemOrdemProducaoPorId(Long id);

	ItemOrdemProducao novoItemOrdemProducao(ItemOrdemProducao itemOrdemProducao);

	void excluirItemOrdemProducao(Long id);

}
