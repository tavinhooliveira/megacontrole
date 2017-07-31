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

import com.megas.controle.model.Categoria;
import com.megas.controle.model.Conta;
import com.megas.controle.model.FormaPagamento;
import com.megas.controle.model.MesCompetencia;
import com.megas.controle.model.Parcela;
import com.megas.controle.model.Pessoa;
import com.megas.controle.model.Status;
import com.megas.controle.model.TipoConta;
import com.megas.controle.repository.Categorias;
import com.megas.controle.repository.Contas;
import com.megas.controle.repository.Parcelas;
import com.megas.controle.repository.Pessoas;

@Controller
@RequestMapping("/controles/conta")
public class ContaController {

private static final String CADASTROCONTA = "/pages/cadastro/CadastroConta";
private static final String PESQUISARCONTA = "/pages/pesquisa/PesquisarConta";
private static final String DETALHE_CONTA_VIEW = "/pages/detalhes/DetalheConta";

@Autowired
private Contas contas;

@Autowired
private Pessoas pessoas;

@Autowired
private Categorias categorias;

@Autowired
private Parcelas parcelas;



	// Cadastro Novo
	@RequestMapping("/novo")
	public ModelAndView CadastoNovo() {
	ModelAndView mv = new ModelAndView(CADASTROCONTA);
	mv.addObject(new Conta());
	return mv;
	}
	
	
	// Salvar 
	@RequestMapping(method = RequestMethod.POST)
	public String salvarConta(@Validated Conta conta, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTROCONTA;
		}
		try {
			contas.save(conta);
			attributes.addFlashAttribute("mensagem","Conta Salva com sucesso!");
			return "redirect:/controles/conta/detalhes/" + conta.getCodigo().toString();
		} catch (IllegalArgumentException e) {
			return PESQUISARCONTA;
		}
	}
		
	
	// Combo Categoria
	@ModelAttribute("ListCategorias")
	public List<Categoria> ListCategorias() {
		return categorias.findAll();
	}
	
	// Combo Pessoas
	@ModelAttribute("ListPessoas")
	public List<Pessoa> ListPessoas() {
		return pessoas.findAll();
	}
	
	// ComboStatus
	@ModelAttribute("AllStatus")
	public List<Status> AllStatus() {
		return Arrays.asList(Status.values());
	}
		
	// ComboFormapagamento
	@ModelAttribute("AllFormaPagamento")
	public List<FormaPagamento> AllFormaPagamento() {
		return Arrays.asList(FormaPagamento.values());
	}
	
	// ComboCompetencia
	@ModelAttribute("AllMesCompetencia")
	public List<MesCompetencia> AllMesCompetencia() {
		return Arrays.asList(MesCompetencia.values());
	}
		
	// ComboCompetencia
	@ModelAttribute("AllTipoConta")
	public List<TipoConta> AllTipoConta() {
		return Arrays.asList(TipoConta.values());
	}	
	
	
		
	//Pesquisar Conta
	@RequestMapping
	public ModelAndView lista() {
		List<Conta> allContas = contas.findAll();
		ModelAndView mv = new ModelAndView(PESQUISARCONTA);
		mv.addObject("contas", allContas);
		return mv;
	}
	
	// Detalhes
	@RequestMapping("detalhes/{codigo}")
	public ModelAndView exibir(@PathVariable("codigo") Conta conta) {
		ModelAndView mv = new ModelAndView(DETALHE_CONTA_VIEW);
		List<Pessoa> allPessoas = pessoas.findAll();
		mv.addObject("ListPessoas", allPessoas);
		List<Parcela> allParcelas = parcelas.findAll();
		mv.addObject("parcelas", allParcelas);
		mv.addObject(conta);
		List<Parcela> allParcelasQTA = parcelas.findByValorParcelaQTA();
		mv.addObject("valorPacelaCont", allParcelasQTA);
		
		return mv;
	}
	
	
	// Editar
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Conta conta) {
		ModelAndView mv = new ModelAndView(CADASTROCONTA);
		List<Pessoa> allPessoas = pessoas.findAll();
		mv.addObject("ListPessoas", allPessoas);
		List<Categoria> allCategorias = categorias.findAll();
		mv.addObject("ListCategorias", allCategorias);		
		mv.addObject(conta);
		return mv;
	}
	
	
	// Excluir
	@RequestMapping(value = "/delete/{codigo}")
	public String excluir(@PathVariable Long codigo, @Validated Conta conta, Errors errors, RedirectAttributes attributes) {
		contas.delete(codigo);
		attributes.addFlashAttribute("mensagem","A Conta foi excluído com sucesso!");
		return "redirect:/controles/conta";
	}
	
	// Detalhes
	@RequestMapping("detalhes/parcela/{codigo}")
	public ModelAndView editarParcela(@PathVariable("codigo") Parcela parcela, Conta conta) {
		ModelAndView mv = new ModelAndView("/pages/cadastro/AlterarParcela");
		mv.addObject(parcela);
		mv.addObject(conta);
		List<Pessoa> allPessoas = pessoas.findAll();
		mv.addObject("ListPessoas", allPessoas);
		return mv;
	}	
	
	
	
	// SalvarPessoaModal
	@RequestMapping(value = "/pessoaModal", method = RequestMethod.POST)
	public String salvarPessoaModal(@Validated Pessoa pessoa , Conta conta, RedirectAttributes attributes) {
			pessoas.save(pessoa);
			attributes.addFlashAttribute("mensagem","Pessoa Salvo com sucesso!");
			
			return "redirect:/controles/conta/novo";
	}
	
	// SalvarCategoriaModal
		@RequestMapping(value = "/categoriaModal", method = RequestMethod.POST)
		public String salvarCategoriaModal(@Validated Categoria categoria , Conta conta, RedirectAttributes attributes) {
				categorias.save(categoria);
				attributes.addFlashAttribute("mensagem","Categoria Salvo com sucesso!");
				
				return "redirect:/controles/conta/novo";
		}

	
}
