package br.com.rafaelpf.rfprod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.service.FuncionarioService;
import br.com.rafaelpf.rfprod.service.MaquinaService;
import br.com.rafaelpf.rfprod.service.OrdemProducaoService;
import br.com.rafaelpf.rfprod.service.ProcessoService;

@Controller
public class IndexController {

	private final OrdemProducaoService ordemProducaoService;

	private final FuncionarioService funcionarioService;

	private final ProcessoService processoService;

	private final MaquinaService maquinaService;

	public IndexController(OrdemProducaoService ordemProducaoService,
						   FuncionarioService funcionarioService,
						   ProcessoService processoService,
						   MaquinaService maquinaService) {
		this.ordemProducaoService = ordemProducaoService;
		this.funcionarioService = funcionarioService;
		this.processoService = processoService;
		this.maquinaService = maquinaService;
	}

	@GetMapping(value = "/")
	public ModelAndView index() {
		Integer quantidadeOrdemProducao = ordemProducaoService.quantidadeOrdemProducao();
		Integer quantidadeFuncionario = funcionarioService.quantidadeFuncionario();
		Integer quantidadeProcesso = processoService.quantidadeProcesso();
		Integer quantidadeMaquina = maquinaService.quantidadeMaquina();

		ModelAndView mView = new ModelAndView("index")
			.addObject("quantidadeOrdemProducao", quantidadeOrdemProducao)
			.addObject("quantidadeFuncionario", quantidadeFuncionario)
			.addObject("quantidadeProcesso", quantidadeProcesso)
			.addObject("quantidadeMaquina", quantidadeMaquina);

		return mView;
	}

}
