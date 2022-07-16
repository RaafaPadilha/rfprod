package br.com.rafaelpf.rfprod.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelpf.rfprod.model.Produto;
import br.com.rafaelpf.rfprod.repository.ProdutoRepository;
import br.com.rafaelpf.rfprod.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> todosProdutos() {
		List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
		return produtos;
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
