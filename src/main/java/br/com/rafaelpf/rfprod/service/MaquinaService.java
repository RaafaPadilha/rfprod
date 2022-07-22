package br.com.rafaelpf.rfprod.service;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.Maquina;

public interface MaquinaService {

	List<Maquina> todasMaquinas();

	Optional<Maquina> maquinaPorId(Long id);

	Maquina novaMaquina(Maquina maquina);

	void excluirMaquina(Long id);

	Integer quantidadeMaquina();

}
