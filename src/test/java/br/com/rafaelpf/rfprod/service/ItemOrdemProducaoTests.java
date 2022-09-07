package br.com.rafaelpf.rfprod.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.rafaelpf.rfprod.model.ItemOrdemProducao;
import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.model.Produto;
import br.com.rafaelpf.rfprod.repository.ItemOrdemProducaoRepository;
import br.com.rafaelpf.rfprod.service.impl.ItemOrdemProducaoServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ItemOrdemProducaoTests {

	@Mock
	private ItemOrdemProducaoRepository itemOrdemProducaoRepository;

	@InjectMocks
	private ItemOrdemProducaoServiceImpl itemOrdemProducaoServiceImpl;

	private Produto produto;
	private OrdemProducao ordemProducao;
	private ItemOrdemProducao itemOrdemProducao;

	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@BeforeEach
	public void setup() throws ParseException {
		produto = Produto.builder()
			.id(1L)
			.nome("Cabo Rígido 750V")
			.categoria("Cabo Rígido")
			.classe("Classe 2")
			.condutores(1)
			.bitola(new BigDecimal(10.00))
			.cor("Verde")
			.build();

		ordemProducao = OrdemProducao.builder()
			.id(1L)
			.dataCriacao(new Date(df.parse("2022-09-05").getTime()))
			.dataInicio(new Date(df.parse("2022-09-05").getTime()))
			.dataFim(new Date(df.parse("2022-09-05").getTime()))
			.build();

		itemOrdemProducao = ItemOrdemProducao.builder()
			.id(1L)
			.produto(produto)
			.quantidade(100)
			.ordemProducao(ordemProducao)
			.build();
	}

	@DisplayName("Testar o método novoItemOrdemProducao")
	@Test
	public void novaOrdemProducaoTeste() {
		when(itemOrdemProducaoRepository.save(itemOrdemProducao)).thenReturn(itemOrdemProducao);

		ItemOrdemProducao novoItemOrdemProducao = itemOrdemProducaoServiceImpl.novoItemOrdemProducao(itemOrdemProducao);

		assertThat(novoItemOrdemProducao).isNotNull();
	}

	@DisplayName("Testar o método itemOrdemProducaoPorIdOrdemProducao")
	@Test
	public void todosItensOrdemProducaoTeste() throws ParseException {
		Produto produto2 = Produto.builder()
			.id(2L)
			.nome("Cabo Rígido HEPR 1kV")
			.categoria("Cabo Rígido")
			.classe("Classe 2")
			.condutores(1)
			.bitola(new BigDecimal(16.00))
			.cor("Azul")
			.build();

		ItemOrdemProducao itemOrdemProducao2 = ItemOrdemProducao.builder()
			.id(2L)
			.produto(produto2)
			.quantidade(1000)
			.ordemProducao(ordemProducao)
			.build();

		when(itemOrdemProducaoRepository.findItemOrdemProducaoByOrderProducaoId(1L)).thenReturn(List.of(itemOrdemProducao, itemOrdemProducao2));

		List<ItemOrdemProducao> itensOrdemProducao = itemOrdemProducaoServiceImpl.itemOrdemProducaoPorIdOrdemProducao(1L);

		assertThat(itensOrdemProducao).isNotNull();
		assertThat(itensOrdemProducao.size()).isEqualTo(2);
	}

	@DisplayName("Testar o método itemOrdemProducaoPorId")
	@Test
	public void itemOrdemProducaoPorIdTeste() {
		when(itemOrdemProducaoRepository.findById(1L)).thenReturn(Optional.of(itemOrdemProducao));

		ItemOrdemProducao itemOrdemProducaoId = itemOrdemProducaoServiceImpl.itemOrdemProducaoPorId(itemOrdemProducao.getId()).get();

		assertThat(itemOrdemProducaoId).isNotNull();
	}

	@DisplayName("Testar o método excluirItemOrdemProducao")
	@Test
	public void excluirItemOrdemProducaoTeste() {
		doNothing().when(itemOrdemProducaoRepository).deleteById(1L);

		itemOrdemProducaoServiceImpl.excluirItemOrdemProducao(1L);

		verify(itemOrdemProducaoRepository, times(1)).deleteById(1L);
	}

}
