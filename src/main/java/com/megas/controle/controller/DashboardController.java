package com.megas.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.megas.controle.repository.Categorias;
import com.megas.controle.repository.Contas;
import com.megas.controle.repository.Parcelas;
import com.megas.controle.repository.Pessoas;


@Controller
@RequestMapping("/controles")
public class DashboardController {
	
	private static final String DASHBOARD = "/pages/Dashboard"; 
	
	@Autowired
	private Pessoas pessoas;
	
	@Autowired
	private Contas contas;
	
	@Autowired
	private Categorias categorias;
	
	@Autowired
	private Parcelas parcelas;
	
	//Dashboard
	@RequestMapping
	public ModelAndView exibir() {
		ModelAndView mv = new ModelAndView(DASHBOARD);		
		mv.addObject("totalPessoas", pessoas.count());
		mv.addObject("totalContas", contas.count());
		mv.addObject("totalCategorias", categorias.count());
		mv.addObject("totalContaReceber", contas.findByTipoContaRECEITA());
		mv.addObject("totalContaDespesa", contas.findByTipoContaDESPESA());
		mv.addObject("pagamentosAtrasados", contas.findByCodigo());
		mv.addObject("qtdPagamentosAtrasado", contas.findByCodigoAtrasado());
		mv.addObject("ultimasContas", contas.findByCodigoUltimos());
		mv.addObject("valorContasReceita", contas.findByValoContaRECEITAvalor());
		mv.addObject("valorContasDespesa", contas.findByValoContaDESPESAvalor());
		mv.addObject("contaVencimentohoje", contas.findByCodigoUltimosVencimentoHoje());
		mv.addObject("contaVencimentoAtrasadoQuant", contas.findByCodigoAtrasadoQuant());
		mv.addObject("valorPacelaQTDA", parcelas.findByValorParcelaQTA());
		mv.addObject("valorPacelaCont", parcelas.findByValorParcelaCONT());		
		
		return mv;

	}
}