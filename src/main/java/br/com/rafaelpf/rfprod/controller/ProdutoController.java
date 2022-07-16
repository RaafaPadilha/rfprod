package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.model.Produto;
import br.com.rafaelpf.rfprod.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/listagemProdutos")
	public ModelAndView listagemProdutos() {
		List<Produto> produtos = produtoService.todosProdutos();
		ModelAndView mView = new ModelAndView("/produto/listagem")
			.addObject("produtos", produtos);
		return mView;
	}

}
