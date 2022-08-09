package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Funcionario;
import br.com.rafaelpf.rfprod.repository.FuncionarioRepository;
import br.com.rafaelpf.rfprod.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	public List<Funcionario> todosFuncionarios() {
		return (List<Funcionario>) funcionarioRepository.findAll();
	}

	@Override
	public Optional<Funcionario> funcionarioPorId(Long id) {
		return funcionarioRepository.findById(id);
	}

	@Override
	public Funcionario novoFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public void excluirFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}

	@Override
	public Integer quantidadeFuncionario() {
		return funcionarioRepository.countFuncionario();
	}

}
