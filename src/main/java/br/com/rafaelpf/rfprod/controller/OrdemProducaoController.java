package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.service.OrdemProducaoService;

@Controller
public class OrdemProducaoController {

	@Autowired
	private OrdemProducaoService ordemProducaoService;

	@GetMapping(value = "/listagemOrdensProducao")
	public ModelAndView listagemMaquinas() {
		List<OrdemProducao> ordensProducao = ordemProducaoService.todasOrdensProducao();
		ModelAndView mView = new ModelAndView("/op/listagem")
			.addObject("ordensProducao", ordensProducao);
		return mView;
	}

    @GetMapping(value = "/novaOrdemProducaoForm")
    public ModelAndView novaOrdemProducaoForm() {
        OrdemProducao ordemProducao = new OrdemProducao();
        ModelAndView mView = new ModelAndView("/op/novo")
            .addObject("ordemProducao", ordemProducao);
        return mView;
    }

	@PostMapping(value = "/novaOrdemProducao")
	public String novaOrdemProducao(@ModelAttribute OrdemProducao ordemProducao) {
		ordemProducaoService.novaOrdemProducao(ordemProducao);
		return "redirect:/listagemOrdensProducao";
	}

    @GetMapping(value = "/alterarOrdemProducaoForm")
    public ModelAndView alterarOrdemProducaoForm(@RequestParam Long id) {
        OrdemProducao ordemProducao = ordemProducaoService.ordemProducaoPorId(id).get();
        ModelAndView mView = new ModelAndView("/op/alterar")
            .addObject("ordemProducao", ordemProducao);
        return mView;
    }

}
