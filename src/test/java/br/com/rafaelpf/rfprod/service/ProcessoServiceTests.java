package br.com.rafaelpf.rfprod.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.repository.ProcessoRepository;
import br.com.rafaelpf.rfprod.service.impl.ProcessoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProcessoServiceTests {

	@Mock
	private ProcessoRepository processoRepository;

	@InjectMocks
	private ProcessoServiceImpl processoServiceImpl;

	private Processo processo;

	@BeforeEach
	public void setup() {
		processo = Processo.builder()
			.id(1L)
			.nome("Extrusão")
			.build();
	}

	@DisplayName("Testar o método novoProcesso")
	@Test
	public void novoProcessoTeste() {
		when(processoRepository.save(processo)).thenReturn(processo);

		Processo novoProcesso = processoServiceImpl.novoProcesso(processo);

		assertThat(novoProcesso).isNotNull();
	}

	@DisplayName("Testar o método todosProcessos")
	@Test
	public void todosProcessosTeste() {
		Processo processo1 = Processo.builder()
			.id(2L)
			.nome("Trefilação")
			.build();

		when(processoRepository.findAll()).thenReturn(List.of(processo, processo1));

		List<Processo> processos = processoServiceImpl.todosProcessos();

		assertThat(processos).isNotNull();
		assertThat(processos.size()).isEqualTo(2);
	}

	@DisplayName("Testar o método processoPorId")
	@Test
	public void processoPorIdTeste() {
		when(processoRepository.findById(1L)).thenReturn(Optional.of(processo));

		Processo processoId = processoServiceImpl.processoPorId(processo.getId()).get();

		assertThat(processoId).isNotNull();
	}

	@DisplayName("Testar o método excluirProcesso")
	@Test
	public void excluirProcessoTeste() {
		doNothing().when(processoRepository).deleteById(1L);

		processoServiceImpl.excluirProcesso(1L);

		verify(processoRepository, times(1)).deleteById(1L);
	}

}
