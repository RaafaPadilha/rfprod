package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.ItemOrdemProducao;
import br.com.rafaelpf.rfprod.repository.ItemOrdemProducaoRepository;
import br.com.rafaelpf.rfprod.service.ItemOrdemProducaoService;

@Service
public class ItemOrdemProducaoServiceImpl implements ItemOrdemProducaoService {

	private final ItemOrdemProducaoRepository itemOrdemProducaoRepository;

	public ItemOrdemProducaoServiceImpl(ItemOrdemProducaoRepository itemOrdemProducaoRepository) {
		this.itemOrdemProducaoRepository = itemOrdemProducaoRepository;
	}

	@Override
	public List<ItemOrdemProducao> itemOrdemProducaoPorIdOrdemProducao(Long idOrdemProducao) {
		return itemOrdemProducaoRepository.findItemOrdemProducaoByOrderProducaoId(idOrdemProducao);
	}

	@Override
	public Optional<ItemOrdemProducao> itemOrdemProducaoPorId(Long id) {
		return itemOrdemProducaoRepository.findById(id);
	}

	@Override
	public ItemOrdemProducao novoItemOrdemProducao(ItemOrdemProducao itemOrdemProducao) {
		return itemOrdemProducaoRepository.save(itemOrdemProducao);
	}

	@Override
	public void excluirItemOrdemProducao(Long id) {
		itemOrdemProducaoRepository.deleteById(id);
	}

}
