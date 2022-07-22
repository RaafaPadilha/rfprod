package br.com.rafaelpf.rfprod.service;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.Funcionario;

public interface FuncionarioService {

	List<Funcionario> todosFuncionarios();

	Optional<Funcionario> funcionarioPorId(Long id);

	Funcionario novoFuncionario(Funcionario funcionario);

	void excluirFuncionario(Long id);

	Integer quantidadeFuncionario();

}
