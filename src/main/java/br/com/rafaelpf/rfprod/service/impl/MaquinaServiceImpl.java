package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.repository.MaquinaRepository;
import br.com.rafaelpf.rfprod.service.MaquinaService;

@Service
public class MaquinaServiceImpl implements MaquinaService {

	private final MaquinaRepository maquinaRepository;

	public MaquinaServiceImpl(MaquinaRepository maquinaRepository) {
		this.maquinaRepository = maquinaRepository;
	}

    @Override
    public List<Maquina> todasMaquinas() {
		return (List<Maquina>) maquinaRepository.findAll();
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
