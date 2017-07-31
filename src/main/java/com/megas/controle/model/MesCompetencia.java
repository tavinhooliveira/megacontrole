package com.megas.controle.model;

public enum MesCompetencia {
	
	JANEIRO("Janeiro"),
	FEVEREIRO("Fevereiro"),
	MARCO("marco"),
	ABRIL("Abril"),
	MAIO("Maio"),
	JUNHO("Junho"),
	JULHO("julho"),
	AGOSTO("Agosto"),
	SETEMBRO("Setembro"),
	OUTUBRO("Outubro"),
	NOVEMBRO("Novembro"),
	DEZEMBRO("Dezembro");
	
	private String descricao;
	
	private MesCompetencia(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao(){
		return descricao;
	}

}
