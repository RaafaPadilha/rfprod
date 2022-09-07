package br.com.rafaelpf.rfprod.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.repository.OrdemProducaoRepository;
import br.com.rafaelpf.rfprod.service.impl.OrdemProducaoServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OrdemProducaoTests {

	@Mock
	private OrdemProducaoRepository ordemProducaoRepository;

	@InjectMocks
	private OrdemProducaoServiceImpl ordemProducaoServiceImpl;

	private OrdemProducao ordemProducao;

	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@BeforeEach
	public void setup() throws ParseException {
		ordemProducao = OrdemProducao.builder()
			.id(1L)
			.dataCriacao(new Date(df.parse("2022-09-05").getTime()))
			.dataInicio(new Date(df.parse("2022-09-05").getTime()))
			.dataFim(new Date(df.parse("2022-09-05").getTime()))
			.build();
	}

	@DisplayName("Testar o método novaOrdemProducao")
	@Test
	public void novaOrdemProducaoTeste() {
		when(ordemProducaoRepository.save(ordemProducao)).thenReturn(ordemProducao);

		OrdemProducao novaOrdemProducao = ordemProducaoServiceImpl.novaOrdemProducao(ordemProducao);

		assertThat(novaOrdemProducao).isNotNull();
	}

	@DisplayName("Testar o método todasOrdensProducao")
	@Test
	public void todasOrdensProducaoTeste() throws ParseException {
		OrdemProducao ordemProducao2 = OrdemProducao.builder()
			.id(2L)
			.dataCriacao(new Date(df.parse("2022-09-05").getTime()))
			.dataInicio(new Date(df.parse("2022-09-05").getTime()))
			.dataFim(new Date(df.parse("2022-09-05").getTime()))
			.build();

		when(ordemProducaoRepository.findAll()).thenReturn(List.of(ordemProducao, ordemProducao2));

		List<OrdemProducao> ordensProducao = ordemProducaoServiceImpl.todasOrdensProducao();

		assertThat(ordensProducao).isNotNull();
		assertThat(ordensProducao.size()).isEqualTo(2);
	}

	@DisplayName("Testar o método ordemProducaoPorId")
	@Test
	public void ordemProducaoPorIdTeste() {
		when(ordemProducaoRepository.findById(1L)).thenReturn(Optional.of(ordemProducao));

		OrdemProducao ordemProducaoId = ordemProducaoServiceImpl.ordemProducaoPorId(ordemProducao.getId()).get();

		assertThat(ordemProducaoId).isNotNull();
	}

}
