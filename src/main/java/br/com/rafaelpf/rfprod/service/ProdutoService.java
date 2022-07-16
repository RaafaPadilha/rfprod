package br.com.rafaelpf.rfprod.service;

import java.util.List;
import java.util.Optional;

import br.com.rafaelpf.rfprod.model.Produto;

public interface ProdutoService {

	List<Produto> todosProdutos();

	Optional<Produto> produtoPorId(Long id);

	Produto novoProduto(Produto produto);

	void excluirProduto(Long id);

}
