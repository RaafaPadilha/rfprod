package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.service.MaquinaService;
import br.com.rafaelpf.rfprod.service.ProcessoService;

@Controller
public class MaquinaController {

	private final MaquinaService maquinaService;

	private final ProcessoService processoService;

	public MaquinaController(MaquinaService maquinaService, ProcessoService processoService) {
		this.maquinaService = maquinaService;
		this.processoService = processoService;
	}

	@GetMapping(value = "/listagemMaquinas")
	public ModelAndView listagemMaquinas() {
		List<Maquina> maquinas = maquinaService.todasMaquinas();

		ModelAndView mView = new ModelAndView("/maquina/listagem")
			.addObject("maquinas", maquinas);

		return mView;
	}

    @GetMapping(value = "/novaMaquinaForm")
    public ModelAndView novaMaquinaForm() {
        Maquina maquina = new Maquina();
		List<Processo> processos = processoService.todosProcessos();

        ModelAndView mView = new ModelAndView("/maquina/novo")
			.addObject("maquina", maquina)
			.addObject("processos", processos);

        return mView;
    }

	@PostMapping(value = "/novaMaquina")
	public String novoProcesso(@ModelAttribute Maquina maquina) {
		maquinaService.novaMaquina(maquina);
		return "redirect:/listagemMaquinas";
	}

    @GetMapping(value = "/alterarMaquinaForm")
    public ModelAndView alterarProcessoForm(@RequestParam Long id) {
        Maquina maquina = maquinaService.maquinaPorId(id).get();
		List<Processo> processos = processoService.todosProcessos();

        ModelAndView mView = new ModelAndView("/maquina/alterar")
			.addObject("maquina", maquina)
			.addObject("processos", processos);

        return mView;
    }

	@GetMapping(value = "/excluirMaquina")
	public String excluirProcesso(@RequestParam Long id) {
		maquinaService.excluirMaquina(id);
		return "redirect:/listagemMaquinas";
	}

}
