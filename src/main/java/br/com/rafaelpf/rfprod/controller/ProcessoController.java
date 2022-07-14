package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.service.ProcessoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	@GetMapping(value="/listagemProcessos")
	public ModelAndView listagemProcessos() {
		List<Processo> processos = processoService.todosProcessos();
		ModelAndView mView = new ModelAndView("/processo/listagem")
			.addObject("processos", processos);
		return mView;
	}

}
