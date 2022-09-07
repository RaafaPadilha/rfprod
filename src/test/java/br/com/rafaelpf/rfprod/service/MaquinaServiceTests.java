package br.com.rafaelpf.rfprod.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.repository.MaquinaRepository;
import br.com.rafaelpf.rfprod.service.impl.MaquinaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MaquinaServiceTests {

	@Mock
	private MaquinaRepository maquinaRepository;

	@InjectMocks
	private MaquinaServiceImpl maquinaServiceImpl;

	private Processo processo;
	private Maquina maquina;

	@BeforeEach
	public void setup() {
		processo = Processo.builder()
			.id(1L)
			.nome("Extrusão")
			.build();

		maquina = Maquina.builder()
			.id(1L)
			.nome("Extrusão")
			.numeracao("EXT-01")
			.descricao("Extrisora Teste")
			.processo(processo)
			.build();
	}

	@DisplayName("Testar o método novaMaquina")
	@Test
	public void novoMaquinaTeste() {
		when(maquinaRepository.save(maquina)).thenReturn(maquina);

		Maquina novaMaquina = maquinaServiceImpl.novaMaquina(maquina);

		assertThat(novaMaquina).isNotNull();
	}

	@DisplayName("Testar o método todasMaquinas")
	@Test
	public void todasMaquinasTeste() {
		Maquina maquina1 = Maquina.builder()
			.id(2L)
			.nome("Extrusão 02")
			.numeracao("EXT-02")
			.descricao("Extrisora Teste 2")
			.build();

		when(maquinaRepository.findAll()).thenReturn(List.of(maquina, maquina1));

		List<Maquina> maquinas = maquinaServiceImpl.todasMaquinas();

		assertThat(maquinas).isNotNull();
		assertThat(maquinas.size()).isEqualTo(2);
	}

	@DisplayName("Testar o método maquinaPorId")
	@Test
	public void maquinaPorIdTeste() {
		when(maquinaRepository.findById(1L)).thenReturn(Optional.of(maquina));

		Maquina maquinaId = maquinaServiceImpl.maquinaPorId(maquina.getId()).get();

		assertThat(maquinaId).isNotNull();
	}

	@DisplayName("Testar o método excluirMaquina")
	@Test
	public void excluirMaquinaTeste() {
		doNothing().when(maquinaRepository).deleteById(1L);

		maquinaServiceImpl.excluirMaquina(1L);

		verify(maquinaRepository, times(1)).deleteById(1L);
	}

}
