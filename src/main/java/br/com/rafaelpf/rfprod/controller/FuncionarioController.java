package br.com.rafaelpf.rfprod.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.model.Funcionario;
import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.service.FuncionarioService;
import br.com.rafaelpf.rfprod.service.MaquinaService;

@Controller
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	private final MaquinaService maquinaService;

	public FuncionarioController(FuncionarioService funcionarioService,
								 MaquinaService maquinaService) {
		this.funcionarioService = funcionarioService;
		this.maquinaService = maquinaService;
	}

	@GetMapping(value = "/listagemFuncionarios")
	public ModelAndView listagemMaquinas() {
		List<Funcionario> funcionarios = funcionarioService.todosFuncionarios();

		ModelAndView mView = new ModelAndView("/funcionario/listagem")
			.addObject("funcionarios", funcionarios);

		return mView;
	}

    @GetMapping(value = "/novoFuncionarioForm")
    public ModelAndView novaMaquinaForm() {
        Funcionario funcionario = new Funcionario();
		List<Maquina> maquinas = maquinaService.todasMaquinas();

        ModelAndView mView = new ModelAndView("/funcionario/novo")
			.addObject("funcionario", funcionario)
			.addObject("maquinas", maquinas);

        return mView;
    }

	@PostMapping(value = "/novoFuncionario")
	public String novoProcesso(@ModelAttribute Funcionario funcionario) {
		funcionarioService.novoFuncionario(funcionario);
		return "redirect:/listagemFuncionarios";
	}

    @GetMapping(value = "/alterarFuncionarioForm")
    public ModelAndView alterarFuncionarioForm(@RequestParam Long id) {
        Funcionario funcionario = funcionarioService.funcionarioPorId(id).get();
		List<Maquina> maquinas = maquinaService.todasMaquinas();

        ModelAndView mView = new ModelAndView("/funcionario/alterar")
			.addObject("funcionario", funcionario)
			.addObject("maquinas", maquinas);

        return mView;
    }

	@GetMapping(value = "/excluirFuncionario")
	public String excluirFuncionario(@RequestParam Long id) {
		funcionarioService.excluirFuncionario(id);
		return "redirect:/listagemFuncionarios";
	}

}
