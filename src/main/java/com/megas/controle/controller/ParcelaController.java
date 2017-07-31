package com.megas.controle.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.megas.controle.model.FormaPagamento;
import com.megas.controle.model.MesCompetencia;
import com.megas.controle.model.Parcela;
import com.megas.controle.model.Pessoa;
import com.megas.controle.model.Status;
import com.megas.controle.repository.Parcelas;
import com.megas.controle.repository.Pessoas;


@Controller
@RequestMapping("/controles/parcela")
public class ParcelaController {
	
private static final String PESQUISARPARCELA = "/pages/pesquisa/PesquisarParcela";


@Autowired
private Parcelas parcelas;

@Autowired
private Pessoas pessoas;

	
	// Salvar 
	@RequestMapping(method = RequestMethod.POST)
	public String salvarConta(@Validated Parcela parcela , Errors errors,
			RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return "redirect:/controles/conta/detalhes/" + parcela.getConta().getCodigo();
			
		}
		try {
			parcelas.save(parcela);
			attributes.addFlashAttribute("mensagem","Parcela Salva com sucesso!");
			return "redirect:/controles/conta/detalhes/" + parcela.getConta().getCodigo();
		} catch (IllegalArgumentException e) {
			return "redirect:/controles/conta/detalhes/" + parcela.getConta().getCodigo();
		}
	}
	
	
	
	// Excluir
	@RequestMapping(value = "/delete/{codigo}")
	public String excluir(@PathVariable("codigo") Parcela parcela, RedirectAttributes attributes) {
		parcelas.delete(parcela);
		attributes.addFlashAttribute("mensagem","Parcela Excluida com sucesso!");
		return "redirect:/controles/conta/detalhes/" + parcela.getConta().getCodigo();
	}

			
	// Editar
	@RequestMapping("/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Parcela parcela) {
		ModelAndView mv = new ModelAndView(PESQUISARPARCELA);
		mv.addObject(parcela);		
		List<Pessoa> allPessoas = pessoas.findAll();
		mv.addObject("ListPessoas", allPessoas);


		return mv;
	}
	
	
	
	// ComboStatus
	@ModelAttribute("AllStatus")
	public List<Status> AllStatus() {
		return Arrays.asList(Status.values());
	}
	
	
	// ComboStatus
	@ModelAttribute("AllFormaPagamento")
	public List<FormaPagamento> AllFormaPagamento() {
		return Arrays.asList(FormaPagamento.values());
	}
	
	// ComboStatus
		@ModelAttribute("AllMesCompetencia")
		public List<MesCompetencia> AllMesCompetencia() {
			return Arrays.asList(MesCompetencia.values());
	}
	
	
	
	
}
