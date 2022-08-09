package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.repository.OrdemProducaoRepository;
import br.com.rafaelpf.rfprod.service.OrdemProducaoService;

@Service
public class OrdemProducaoServiceImpl implements OrdemProducaoService {

	private final OrdemProducaoRepository ordemProducaoRepository;

	public OrdemProducaoServiceImpl(OrdemProducaoRepository ordemProducaoRepository) {
		this.ordemProducaoRepository = ordemProducaoRepository;
	}

	@Override
	public List<OrdemProducao> todasOrdensProducao() {
		return (List<OrdemProducao>) ordemProducaoRepository.findAll();
	}

	@Override
	public Optional<OrdemProducao> ordemProducaoPorId(Long id) {
		return ordemProducaoRepository.findById(id);
	}

	@Override
	public OrdemProducao novaOrdemProducao(OrdemProducao ordemProducao) {
		return ordemProducaoRepository.save(ordemProducao);
	}

	@Override
	public Integer quantidadeOrdemProducao() {
		return ordemProducaoRepository.countOrdemProducao();
	}

}
