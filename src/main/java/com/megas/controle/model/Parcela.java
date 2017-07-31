package com.megas.controle.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Parcela {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "A Descrição da parcela é Obrigatória")
	@Size(max = 80, message = "A descrição não pode conter mas de 80 caracteres")
	private String descricaoParcela;
	
	
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	@DecimalMin(value = "0.01", message = "O Valo não pode ser menor que 0,1")
	@DecimalMax(value = "9999999.99", message = "O valor nào pode ser maior que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorParcela;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private MesCompetencia mesCompetencia;
		
	private String numeroDocumento;
	
	private String notaFiscalNF;
	
	@ManyToOne
	@JoinColumn(name = "codigo_conta")
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	private Pessoa pessoa;
	
	
	//IS Enum Status
	public boolean isPendente(){		
		return Status.PENDENTE.equals(this.status);
	}
	
	public boolean isAtrasado(){
		return Status.ATRASADO.equals(status);
	}
	
	public boolean isPago(){
		return Status.PAGO.equals(status);
	}
	
	
	//Getters and Setters

	public Long getCodigo() {
		return codigo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoParcela() {
		return descricaoParcela;
	}

	public void setDescricaoParcela(String descricaoParcela) {
		this.descricaoParcela = descricaoParcela;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public MesCompetencia getMesCompetencia() {
		return mesCompetencia;
	}

	public void setMesCompetencia(MesCompetencia mesCompetencia) {
		this.mesCompetencia = mesCompetencia;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNotaFiscalNF() {
		return notaFiscalNF;
	}

	public void setNotaFiscalNF(String notaFiscalNF) {
		this.notaFiscalNF = notaFiscalNF;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	
	
	
	
	
	// hashCode e equals
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
		Parcela other = (Parcela) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

	
	
	
	

}
