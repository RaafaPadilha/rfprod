package br.com.rafaelpf.rfprod.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.rafaelpf.rfprod.model.Apontamento;
import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.repository.ApontamentoRepository;
import br.com.rafaelpf.rfprod.service.impl.ApontamentoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ApontamentoServiceTests {

	@Mock
	private ApontamentoRepository apontamentoRepository;

	@InjectMocks
	private ApontamentoServiceImpl apontamentoServiceImpl;

	private Processo processo;
	private Maquina maquina;
	private OrdemProducao ordemProducao;
	private Apontamento apontamento;

	@BeforeEach
	public void setup() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

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

		ordemProducao = OrdemProducao.builder()
			.id(1L)
			.dataCriacao(new Date(df.parse("2022-09-05").getTime()))
			.dataInicio(new Date(df.parse("2022-09-05").getTime()))
			.dataFim(new Date(df.parse("2022-09-05").getTime()))
			.build();

		apontamento = Apontamento.builder()
			.id(1L)
			.dataAtual(new Date(df.parse("2022-09-06").getTime()))
			.horaInicio(Time.valueOf("13:00:00"))
			.horaFim(Time.valueOf("22:00:00"))
			.maquina(maquina)
			.ordemProducao(ordemProducao)
			.build();
	}

	@DisplayName("Testar o método apontamentoPorIdTeste")
	@Test
	public void apontamentoPorIdTeste() {
		when(apontamentoRepository.findById(1L)).thenReturn(Optional.of(apontamento));

		Apontamento apontamentoId = apontamentoServiceImpl.apontamentoPorId(apontamento.getId()).get();

		assertThat(apontamentoId).isNotNull();
	}

	@DisplayName("Testar o método novoApontamentoTeste")
	@Test
	public void novoApontamentoTeste() {
		when(apontamentoRepository.save(apontamento)).thenReturn(apontamento);

		Apontamento novoApontamento = apontamentoServiceImpl.novoApontamento(apontamento);

		assertThat(novoApontamento).isNotNull();
	}

	@DisplayName("Testar o método excluirApontamento")
	@Test
	public void excluirApontamentoTeste() {
		doNothing().when(apontamentoRepository).deleteById(1L);

		apontamentoServiceImpl.excluirApontamento(1L);

		verify(apontamentoRepository, times(1)).deleteById(1L);
	}

}
