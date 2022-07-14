package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;

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

}
