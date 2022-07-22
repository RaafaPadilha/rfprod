package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.repository.ordemProducaoRepository;
import br.com.rafaelpf.rfprod.service.OrdemProducaoService;

@Service
public class OrdemProducaoServiceImpl implements OrdemProducaoService {

	@Autowired
	private ordemProducaoRepository ordemProducaoRepository;

	@Override
	public List<OrdemProducao> todasOrdensProducao() {
		List<OrdemProducao> ordensProducao = (List<OrdemProducao>) ordemProducaoRepository.findAll();
		return ordensProducao;
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
