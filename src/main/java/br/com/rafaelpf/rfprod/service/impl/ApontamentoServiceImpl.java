package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Apontamento;
import br.com.rafaelpf.rfprod.repository.ApontamentoRepository;
import br.com.rafaelpf.rfprod.service.ApontamentoService;

@Service
public class ApontamentoServiceImpl implements ApontamentoService {

	@Autowired
	private ApontamentoRepository apontamentoRepository;

	@Override
	public List<Apontamento> apontamentoPorIdOrdemProducao(Long idOrdemProducao) {
		List<Apontamento> apontamentos = apontamentoRepository.findApontamentoByOrderProducaoId(idOrdemProducao);
		return apontamentos;
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
