package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.repository.ProcessoRepository;
import br.com.rafaelpf.rfprod.service.ProcessoService;

@Service
public class ProcessoServiceImpl implements ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;

	@Override
	public List<Processo> todosProcessos() {
		List<Processo> processos = (List<Processo>) processoRepository.findAll();
		return processos;
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

}
