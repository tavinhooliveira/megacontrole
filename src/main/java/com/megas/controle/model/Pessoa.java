package com.megas.controle.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "O Nome é Obrigatório")
	private String nomePessoa;
	
	private String apelido;
	
	private String cpf;
	
	private String cnpj;
	
	private String celular;
	
	private String telefone;
	
	private String email;
	
	private String endereco;
	
	private String numero;
	
	private String bairro;
	
	private String cidade;
	
	private String complemento;
	
	private String observacao;
	
	@Enumerated(EnumType.STRING)
	private Uf uf;
	
	private String tipoPessoa;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Conta> conta;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Parcela> parcela;
	
	
	//UF Estado	
	public boolean isAcre(){
		return Uf.AC.equals(uf);
	}
	
	public boolean isAlagoas(){
		return Uf.AL.equals(uf);
	}
	
	public boolean isAmazonas(){
		return Uf.AM.equals(uf);
	}
	
	public boolean isAmapá(){
		return Uf.AP.equals(uf);
	}
	
	public boolean isBahia(){
		return Uf.BA.equals(uf);
	}
	
	public boolean isCeará(){
		return Uf.CE.equals(uf);
	}
	
	public boolean isDistritoFederal(){
		return Uf.DF.equals(uf);
	}
	
	public boolean isEspiritoSanto(){
		return Uf.ES.equals(uf);
	}
	
	public boolean isGoias(){
		return Uf.GO.equals(uf);
	}
	
	public boolean isMaranhão(){
		return Uf.MA.equals(uf);
	}
	
	public boolean isMinasGerais(){
		return Uf.MG.equals(uf);
	}
    
	public boolean isMatoGrossoSul(){
		return Uf.MS.equals(uf);
	}
	
	public boolean isMatoGrosso(){
		return Uf.MT.equals(uf);
	}
	
	public boolean isPará(){
		return Uf.PA.equals(uf);
	}
	
	public boolean isParaiba(){
		return Uf.PB.equals(uf);
	}
	
	public boolean isPiauio(){
		return Uf.PI.equals(uf);
	}
	
	public boolean isParana(){
		return Uf.PR.equals(uf);
	}
	
	public boolean isRiodeJaneiro(){
		return Uf.RJ.equals(uf);
	}
	
	public boolean isRioGrandedoNorte(){
		return Uf.RN.equals(uf);
	}
	
	public boolean isRondônia(){
		return Uf.RO.equals(uf);
	}
	
	public boolean isRoraima(){
		return Uf.RR.equals(uf);
	}
	
	public boolean isRioGrandedoSul(){
		return Uf.RS.equals(uf);
	}
	
	public boolean isSantaCatarina(){
		return Uf.SC.equals(uf);
	}
	
	public boolean isSergipe(){
		return Uf.SE.equals(uf);
	}
	
	public boolean isSãoPaulo(){
		return Uf.SP.equals(uf);
	}
	
	public boolean isTocantins(){
		return Uf.TO.equals(uf);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNomePessoa() {
		return nomePessoa;
	}


	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	public List<Conta> getConta() {
		return conta;
	}

	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}
	

	public List<Parcela> getParcela() {
		return parcela;
	}

	public void setParcela(List<Parcela> parcela) {
		this.parcela = parcela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
     
	
	
	

}
