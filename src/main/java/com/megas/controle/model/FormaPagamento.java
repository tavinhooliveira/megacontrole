package com.megas.controle.model;

public enum FormaPagamento {
	
	AVISTA("Avista"),
	PARCELADO("Parcelado");
	
	private String descricao;
	
	private FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao(){
		return descricao;
	}

}
