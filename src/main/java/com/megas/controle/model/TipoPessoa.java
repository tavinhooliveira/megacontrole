package com.megas.controle.model;

public enum TipoPessoa {
	
	PF("Fisica"),
	PJ("Juridica");
	
	private String descricao;
	
	private TipoPessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao(){
		return descricao;
	}


}
