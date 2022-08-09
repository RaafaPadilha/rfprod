package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rafaelpf.rfprod.model.Apontamento;
import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.service.ApontamentoService;
import br.com.rafaelpf.rfprod.service.MaquinaService;
import br.com.rafaelpf.rfprod.service.OrdemProducaoService;

@Controller
public class ApontamentoController {

	private final ApontamentoService apontamentoService;

	private final MaquinaService maquinaService;

	private final OrdemProducaoService ordemProducaoService;

	public ApontamentoController(ApontamentoService apontamentoService,
								 MaquinaService maquinaService,
								 OrdemProducaoService ordemProducaoService) {
		this.apontamentoService = apontamentoService;
		this.maquinaService = maquinaService;
		this.ordemProducaoService = ordemProducaoService;
	}

	@GetMapping(value = "/listagemApontamentos")
	public ModelAndView listagemApontamentos(@RequestParam Long id) {
		List<Apontamento> apontamentos = apontamentoService.apontamentoPorIdOrdemProducao(id);
		OrdemProducao ordemProducao = ordemProducaoService.ordemProducaoPorId(id).get();

		ModelAndView mView = new ModelAndView("/op/apontamento/listagem")
			.addObject("apontamentos", apontamentos)
			.addObject("ordemProducao", ordemProducao);

		return mView;
	}

    @GetMapping(value = "/novoApontamentoForm")
    public ModelAndView novoApontamentoForm(@RequestParam Long id) {
        Apontamento apontamento = new Apontamento();
		List<Maquina> maquinas = maquinaService.todasMaquinas();
		OrdemProducao ordemProducao = ordemProducaoService.ordemProducaoPorId(id).get();

		ModelAndView mView = new ModelAndView("/op/apontamento/novo")
			.addObject("apontamento", apontamento)
			.addObject("maquinas", maquinas)
			.addObject("ordemProducao", ordemProducao);

		return mView;
    }

	@PostMapping(value = "/novoApontamento")
	public String novoProcesso(@ModelAttribute Apontamento apontamento, RedirectAttributes redirectAttributes) {
		apontamentoService.novoApontamento(apontamento);

		// ID da Ordem de produção para a listagem dos apontamentos
		redirectAttributes.addAttribute("id", apontamento.getOrdemProducao().getId());

		return "redirect:/listagemApontamentos";
	}

    @GetMapping(value = "/alterarApontamentoForm")
    public ModelAndView alterarProcessoForm(@RequestParam Long id) {
        Apontamento apontamento = apontamentoService.apontamentoPorId(id).get();
		List<Maquina> maquinas = maquinaService.todasMaquinas();

        ModelAndView mView = new ModelAndView("/op/apontamento/alterar")
            .addObject("apontamento", apontamento)
			.addObject("maquinas", maquinas);

        return mView;
    }

	@GetMapping(value = "/excluirApontamento")
	public String excluirApontamento(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		Apontamento apontamento = apontamentoService.apontamentoPorId(id).get();

		apontamentoService.excluirApontamento(apontamento.getId());

		// ID da Ordem de produção para a listagem dos apontamentos
		redirectAttributes.addAttribute("id", apontamento.getOrdemProducao().getId());

		return "redirect:/listagemApontamentos";
	}

}
