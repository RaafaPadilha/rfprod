package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Produto;
import br.com.rafaelpf.rfprod.repository.ProdutoRepository;
import br.com.rafaelpf.rfprod.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Produto> todosProdutos() {
		return (List<Produto>) produtoRepository.findAll();
	}

	@Override
	public Optional<Produto> produtoPorId(Long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public Produto novoProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public void excluirProduto(Long id) {
		produtoRepository.deleteById(id);
	}

}
