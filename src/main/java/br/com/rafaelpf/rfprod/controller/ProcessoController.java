package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.service.ProcessoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	@GetMapping(value = "/listagemProcessos")
	public ModelAndView listagemProcessos() {
		List<Processo> processos = processoService.todosProcessos();
		ModelAndView mView = new ModelAndView("/processo/listagem")
			.addObject("processos", processos);
		return mView;
	}

    @GetMapping(value = "/novoProcessoForm")
    public ModelAndView novoProcessoForm() {
        Processo processo = new Processo();
        ModelAndView mView = new ModelAndView("/processo/novo")
            .addObject("processo", processo);
        return mView;
    }

	@PostMapping(value = "/novoProcesso")
	public String novoProcesso(@ModelAttribute Processo processo) {
		processoService.novoProcesso(processo);
		return "redirect:/listagemProcessos";
	}

    @GetMapping(value = "/alterarProcessoForm")
    public ModelAndView alterarProcessoForm(@RequestParam Long id) {
        Processo processo = processoService.processoPorId(id).get();
        ModelAndView mView = new ModelAndView("/processo/alterar")
            .addObject("processo", processo);
        return mView;
    }

	@GetMapping(value = "/excluirProcesso")
	public String excluirProcesso(@RequestParam Long id) {
		processoService.excluirProcesso(id);
		return "redirect:/listagemProcessos";
	}

}
