package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.service.MaquinaService;

@Controller
public class MaquinaController {

	@Autowired
	private MaquinaService maquinaService;

	@GetMapping(value = "/listagemMaquinas")
	public ModelAndView listagemMaquinas() {
		List<Maquina> maquinas = maquinaService.todasMaquinas();
		ModelAndView mView = new ModelAndView("/maquina/listagem")
			.addObject("maquinas", maquinas);
			return mView;
	}

}
