package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rafaelpf.rfprod.model.ItemOrdemProducao;
import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.model.Produto;
import br.com.rafaelpf.rfprod.service.ItemOrdemProducaoService;
import br.com.rafaelpf.rfprod.service.OrdemProducaoService;
import br.com.rafaelpf.rfprod.service.ProdutoService;

@Controller
public class ItemOrdemProducaoController {

	@Autowired
	private ItemOrdemProducaoService itemOrdemProducaoService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private OrdemProducaoService ordemProducaoService;

	@GetMapping(value = "/listagemItensOrdemProducao")
	public ModelAndView listagemMaquinas(@RequestParam Long id) {
		ItemOrdemProducao novoItemOrdemProducao = new ItemOrdemProducao();
		List<ItemOrdemProducao> itensOrdemProducao = itemOrdemProducaoService.itemOrdemProducaoPorIdOrdemProducao(id);
		List<Produto> produtos = produtoService.todosProdutos();
		OrdemProducao ordemProducao = ordemProducaoService.ordemProducaoPorId(id).get();

		ModelAndView mView = new ModelAndView("/op/item/listagem")
			.addObject("novoItemOrdemProducao", novoItemOrdemProducao)
			.addObject("itensOrdemProducao", itensOrdemProducao)
			.addObject("produtos", produtos)
			.addObject("ordemProducao", ordemProducao);

		return mView;
	}

	@PostMapping(value = "/novoItemOrdemProducao")
	public String novoItemOrdemProducao(@ModelAttribute ItemOrdemProducao itemOrdemProducao, RedirectAttributes redirectAttributes) {
		itemOrdemProducaoService.novoItemOrdemProducao(itemOrdemProducao);

		redirectAttributes.addAttribute("id", itemOrdemProducao.getOrdemProducao().getId());

		return "redirect:/listagemItensOrdemProducao";
	}

	@GetMapping(value = "/excluirItemOrdemProducao")
	public String excluirProcesso(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		ItemOrdemProducao itemOrdemProducao = itemOrdemProducaoService.itemOrdemProducaoPorId(id).get();

		itemOrdemProducaoService.excluirItemOrdemProducao(itemOrdemProducao.getId());

		redirectAttributes.addAttribute("id", itemOrdemProducao.getOrdemProducao().getId());

		return "redirect:/listagemItensOrdemProducao";
	}

}
