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

import com.megas.controle.model.Pessoa;
import com.megas.controle.model.Uf;
import com.megas.controle.repository.Pessoas;


@Controller
@RequestMapping("/controles/pessoa")
public class PessoaController {
	
private static final String CADASTROPESSOA = "/pages/cadastro/CadastroPessoa";
private static final String PESQUISARPESSOA = "/pages/pesquisa/PesquisarPessoa";


@Autowired
private Pessoas	pessoas;


	//Cadastro Nova Pessoa
	@RequestMapping("/novo")
	public ModelAndView CadastoNovaPessoa() {
		ModelAndView mv = new ModelAndView(CADASTROPESSOA);
		mv.addObject(new Pessoa());
		return mv;
	}
	
	
	// Salvar 
		@RequestMapping(method = RequestMethod.POST)
		public String salvarPessoa(@Validated Pessoa pessoa , Errors errors,
				RedirectAttributes attributes) {
			if (errors.hasErrors()) {
				return CADASTROPESSOA;
			}
			try {
				pessoas.save(pessoa);
				attributes.addFlashAttribute("mensagem","Pessoa Salvo com sucesso!");
				return "redirect:/controles/pessoa/novo";
			} catch (IllegalArgumentException e) {
				return CADASTROPESSOA;
			}
		}
	
	
	//Pesquisar Pessoa
	@RequestMapping
	public ModelAndView lista() {
		List<Pessoa> allPessoas = pessoas.findAll();
		ModelAndView mv = new ModelAndView(PESQUISARPESSOA);
		mv.addObject("pessoas", allPessoas);
		return mv;
	}
		
	// ComboTiposUF
	@ModelAttribute("Alluf")
	public List<Uf> Alluf() {
		return Arrays.asList(Uf.values());
	}
	
	
	// Editar
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Pessoa pessoa) {
		ModelAndView mv = new ModelAndView(CADASTROPESSOA);
		mv.addObject(pessoa);
		return mv;
	}
	
	
	// Excluir
	@RequestMapping(value = "/delete/{codigo}")
	public String excluir(@PathVariable Long codigo, @Validated Pessoa pessoa, Errors errors, RedirectAttributes attributes) {
		pessoas.delete(codigo);
		attributes.addFlashAttribute("mensagem","A Pessoa foi excluído com sucesso!");
		return "redirect:/controles/pessoa";
	}
	
	
}




