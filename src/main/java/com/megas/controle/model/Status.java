package com.megas.controle.model;

public enum Status {
	
	PENDENTE("Pendente"),
	PAGO("Pago"),
	ATRASADO("Atrasado");
	
	private String descricao;
	
	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao(){
		return descricao;
	}

}
