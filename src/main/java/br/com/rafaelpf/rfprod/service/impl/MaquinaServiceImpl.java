package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.repository.MaquinaRepository;
import br.com.rafaelpf.rfprod.service.MaquinaService;

@Service
public class MaquinaServiceImpl implements MaquinaService {

	@Autowired
	private MaquinaRepository maquinaRepository;

    @Override
    public List<Maquina> todasMaquinas() {
		List<Maquina> maquinas = (List<Maquina>) maquinaRepository.findAll();
		return maquinas;
    }

    @Override
    public Optional<Maquina> maquinaPorId(Long id) {
		return maquinaRepository.findById(id);
    }

    @Override
    public Maquina novaMaquina(Maquina maquina) {
		return maquinaRepository.save(maquina);
    }

    @Override
    public void excluirMaquina(Long id) {
		maquinaRepository.deleteById(id);
    }

	@Override
	public Integer quantidadeMaquina() {
		return maquinaRepository.countMaquina();
	}

}
