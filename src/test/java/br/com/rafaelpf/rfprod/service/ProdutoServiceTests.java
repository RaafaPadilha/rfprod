package br.com.rafaelpf.rfprod.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.rafaelpf.rfprod.model.Produto;
import br.com.rafaelpf.rfprod.repository.ProdutoRepository;
import br.com.rafaelpf.rfprod.service.impl.ProdutoServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTests {

	@Mock
	private ProdutoRepository produtoRepository;

	@InjectMocks
	private ProdutoServiceImpl produtoServiceImpl;

	private Produto produto;

	@BeforeEach
	public void setup() {
		produto = Produto.builder()
			.id(1L)
			.nome("Cabo Flexível")
			.categoria("Cabo Flexível")
			.classe("4")
			.condutores(4)
			.bitola(new BigDecimal(1))
			.cor("Preta")
			.build();
	}

	@DisplayName("Testar o método novoProduto")
	@Test
	public void novoProdutoTeste() {
		when(produtoRepository.save(produto)).thenReturn(produto);

		Produto novoProduto = produtoServiceImpl.novoProduto(produto);

		assertThat(novoProduto).isNotNull();
	}

	@DisplayName("Testar o método todosProdutos")
	@Test
	public void todosProdutosTeste() {
		Produto produto1 = Produto.builder()
			.id(1L)
			.nome("Cabo Flexível 1")
			.categoria("Cabo Flexível 1")
			.classe("4")
			.condutores(4)
			.bitola(new BigDecimal(1))
			.cor("Preta")
			.build();

		when(produtoRepository.findAll()).thenReturn(List.of(produto, produto1));

		List<Produto> produtos = produtoServiceImpl.todosProdutos();

		assertThat(produtos).isNotNull();
		assertThat(produtos.size()).isEqualTo(2);
	}

	@DisplayName("Testar o método produtoPorId")
	@Test
	public void maquinaPorIdTeste() {
		when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

		Produto produtoId = produtoServiceImpl.produtoPorId(produto.getId()).get();

		assertThat(produtoId).isNotNull();
	}

	@DisplayName("Testar o método excluirProduto")
	@Test
	public void excluirMaquinaTeste() {
		doNothing().when(produtoRepository).deleteById(1L);

		produtoServiceImpl.excluirProduto(1L);

		verify(produtoRepository, times(1)).deleteById(1L);
	}

}
