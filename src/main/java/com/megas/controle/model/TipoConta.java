package com.megas.controle.model;

public enum TipoConta {
	
	DESPESA("Despesa"),
	RECEITA("Receita");
	
	private String descricao;
	
	private TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao(){
		return descricao;
	}

}
