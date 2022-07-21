package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.ItemOrdemProducao;
import br.com.rafaelpf.rfprod.repository.ItemOrdemProducaoRepository;
import br.com.rafaelpf.rfprod.service.ItemOrdemProducaoService;

@Service
public class ItemOrdemProducaoServiceImpl implements ItemOrdemProducaoService {

	@Autowired
	private ItemOrdemProducaoRepository itemOrdemProducaoRepository;

	@Override
	public List<ItemOrdemProducao> itemOrdemProducaoPorIdOrdemProducao(Long idOrdemProducao) {
		List<ItemOrdemProducao> apontamentos = itemOrdemProducaoRepository.findItemOrdemProducaoByOrderProducaoId(idOrdemProducao);
		return apontamentos;
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
