package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.model.Produto;
import br.com.rafaelpf.rfprod.service.ProdutoService;

@Controller
public class ProdutoController {

	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping(value = "/listagemProdutos")
	public ModelAndView listagemProdutos() {
		List<Produto> produtos = produtoService.todosProdutos();

		ModelAndView mView = new ModelAndView("/produto/listagem")
			.addObject("produtos", produtos);

		return mView;
	}

    @GetMapping(value = "/novoProdutoForm")
    public ModelAndView novoProdutoForm() {
        Produto produto = new Produto();

		ModelAndView mView = new ModelAndView("/produto/novo")
			.addObject("produto", produto);

		return mView;
    }

	@PostMapping(value = "/novoProduto")
	public String novoProduto(@ModelAttribute Produto produto) {
		produtoService.novoProduto(produto);
		return "redirect:/listagemProdutos";
	}

    @GetMapping(value = "/alterarProdutoForm")
    public ModelAndView alterarProcessoForm(@RequestParam Long id) {
        Produto produto = produtoService.produtoPorId(id).get();

        ModelAndView mView = new ModelAndView("/produto/alterar")
            .addObject("produto", produto);

        return mView;
    }

	@GetMapping(value = "/excluirProduto")
	public String excluirProcesso(@RequestParam Long id) {
		produtoService.excluirProduto(id);
		return "redirect:/listagemProdutos";
	}

}
