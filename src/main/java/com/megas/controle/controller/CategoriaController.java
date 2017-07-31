package com.megas.controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.megas.controle.model.Categoria;
import com.megas.controle.repository.Categorias;


@Controller
@RequestMapping("/controles/categoria")
public class CategoriaController {
	
private static final String CADASTROCATEGORIA = "/pages/cadastro/CadastroCategoria";
private static final String PESQUISARCATEGORIA = "/pages/pesquisa/PesquisarCategoria";

@Autowired
private Categorias categorias;

	//Cadastro Nova Categoraia
	@RequestMapping("/novo")
	public ModelAndView CadastoNovaCategoria() {
		ModelAndView mv = new ModelAndView(CADASTROCATEGORIA);
		mv.addObject(new Categoria());
		return mv;
	}
	
	
	// Salvar 
	@RequestMapping(method = RequestMethod.POST)
	public String salvarCategoria(@Validated Categoria categoria , Errors errors,
			RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTROCATEGORIA;
		}
		try {
			categorias.save(categoria);
			attributes.addFlashAttribute("mensagem","Categoria Salva com sucesso!");
			return "redirect:/controles/categoria/novo";
		} catch (IllegalArgumentException e) {
			return CADASTROCATEGORIA;
		}
	}
	
	//Pesquisar Categoria
	@RequestMapping
	public ModelAndView lista() {
		List<Categoria> allCategorias = categorias.findAll();
		ModelAndView mv = new ModelAndView(PESQUISARCATEGORIA);
		mv.addObject("categorias", allCategorias);
		return mv;
	}
	
	
	
	// Editar
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Categoria categoria) {
		ModelAndView mv = new ModelAndView(CADASTROCATEGORIA);
		mv.addObject(categoria);
		return mv;
	}
	
	
	// Excluir
	@RequestMapping(value = "/delete/{codigo}")
	public String excluir(@PathVariable Long codigo, @Validated Categoria categoria, Errors errors, RedirectAttributes attributes) {
		categorias.delete(codigo);
		attributes.addFlashAttribute("mensagem","A Categoria foi excluído com sucesso!");
		return "redirect:/controles/categoria";
	}
			

}
