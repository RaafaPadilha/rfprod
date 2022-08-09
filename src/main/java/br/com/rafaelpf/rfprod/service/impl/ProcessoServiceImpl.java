package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.repository.ProcessoRepository;
import br.com.rafaelpf.rfprod.service.ProcessoService;

@Service
public class ProcessoServiceImpl implements ProcessoService {

	private final ProcessoRepository processoRepository;

	public ProcessoServiceImpl(ProcessoRepository processoRepository) {
		this.processoRepository = processoRepository;
	}

	@Override
	public List<Processo> todosProcessos() {
		return (List<Processo>) processoRepository.findAll();
	}

	@Override
	public Optional<Processo> processoPorId(Long id) {
		return processoRepository.findById(id);
	}

	@Override
	public Processo novoProcesso(Processo processo) {
		return processoRepository.save(processo);
	}

	@Override
	public void excluirProcesso(Long id) {
		processoRepository.deleteById(id);
	}

	@Override
	public Integer quantidadeProcesso() {
		return processoRepository.countProcesso();
	}

}
