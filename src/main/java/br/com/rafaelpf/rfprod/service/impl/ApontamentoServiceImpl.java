package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Apontamento;
import br.com.rafaelpf.rfprod.repository.ApontamentoRepository;
import br.com.rafaelpf.rfprod.service.ApontamentoService;

@Service
public class ApontamentoServiceImpl implements ApontamentoService {

	private final ApontamentoRepository apontamentoRepository;

	private ApontamentoServiceImpl(ApontamentoRepository apontamentoRepository) {
		this.apontamentoRepository = apontamentoRepository;
	}

	@Override
	public List<Apontamento> apontamentoPorIdOrdemProducao(Long idOrdemProducao) {
		return (List<Apontamento>) apontamentoRepository.findApontamentoByOrderProducaoId(idOrdemProducao);
	}

	@Override
	public Optional<Apontamento> apontamentoPorId(Long id) {
		return apontamentoRepository.findById(id);
	}

	@Override
	public Apontamento novoApontamento(Apontamento apontamento) {
		return apontamentoRepository.save(apontamento);
	}

	@Override
	public void excluirApontamento(Long id) {
		apontamentoRepository.deleteById(id);
	}

}
