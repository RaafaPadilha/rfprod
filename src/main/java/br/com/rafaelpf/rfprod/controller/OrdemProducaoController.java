package br.com.rafaelpf.rfprod.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelpf.rfprod.model.OrdemProducao;
import br.com.rafaelpf.rfprod.service.OrdemProducaoService;
import br.com.rafaelpf.rfprod.util.OrdemProducaoExcelGenerator;

@Controller
public class OrdemProducaoController {

	private final OrdemProducaoService ordemProducaoService;

	public OrdemProducaoController(OrdemProducaoService ordemProducaoService) {
		this.ordemProducaoService = ordemProducaoService;
	}

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

	@GetMapping("/exportarOrdemProducaoParaExcel")
	public void exportarOrdemProducaoParaExcel(HttpServletResponse response) throws IOException {
	  response.setContentType("application/octet-stream");
	  DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	  String currentDateTime = dateFormatter.format(new Date());

	  String headerKey = "Content-Disposition";
	  String headerValue = "attachment; filename=ordemProducao" + currentDateTime + ".xlsx";
	  response.setHeader(headerKey, headerValue);

	  List <OrdemProducao> listaOrdensProducao = ordemProducaoService.todasOrdensProducao();

	  OrdemProducaoExcelGenerator generator = new OrdemProducaoExcelGenerator(listaOrdensProducao);

	  generator.generateExcelFile(response);
	}

}
