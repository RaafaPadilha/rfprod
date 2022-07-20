package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rafaelpf.rfprod.model.Apontamento;
import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.service.ApontamentoService;
import br.com.rafaelpf.rfprod.service.MaquinaService;

@Controller
public class ApontamentoController {

	@Autowired
	private ApontamentoService apontamentoService;

	@Autowired
	private MaquinaService maquinaService;

	@GetMapping(value = "/listagemApontamentos")
	public ModelAndView listagemApontamentos(@RequestParam Long id) {
		List<Apontamento> apontamentos = apontamentoService.apontamentoPorIdOrdemProducao(id);

		ModelAndView mView = new ModelAndView("/op/apontamento/listagem")
			.addObject("apontamentos", apontamentos);

		return mView;
	}

    @GetMapping(value = "/novoApontamentoForm")
    public ModelAndView novoApontamentoForm() {
        Apontamento apontamento = new Apontamento();
		List<Maquina> maquinas = maquinaService.todasMaquinas();

		ModelAndView mView = new ModelAndView("/op/apontamento/novo")
			.addObject("apontamento", apontamento)
			.addObject("maquinas", maquinas);

		return mView;
    }

	@PostMapping(value = "/novoApontamento")
	public String novoProcesso(@ModelAttribute Apontamento apontamento, RedirectAttributes redirectAttributes) {
		apontamentoService.novoApontamento(apontamento);

		// ID da Ordem de produção para a listagem dos apontamentos
		redirectAttributes.addAttribute("id", apontamento.getOrdemProducao().getId());

		return "redirect:/listagemApontamentos";
	}

}
