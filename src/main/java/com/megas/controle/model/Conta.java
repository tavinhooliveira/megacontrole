package com.megas.controle.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Conta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "A Descrição é Obrigatória")
	@Size(max = 200, message = "A descrição não pode conter mas de 200 caracteres")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;
	
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
//	@DecimalMin(value = "0.01", message = "O Valo não pode ser menor que 0,1")
	@DecimalMax(value = "9999999.99", message = "O valor nào pode ser maior que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorConta;
	
	private Integer totalParcela;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	private Pessoa pessoa;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "conta")
	private List<Parcela> parcela;
	
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
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
	
	//IS Enum TipoConta
	public boolean isReceita(){		
		return TipoConta.RECEITA.equals(this.tipoConta);
	}
			
	public boolean isDespesa(){
		return TipoConta.DESPESA.equals(tipoConta);
	}
	
	//Getters and Setters

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValorConta() {
		return valorConta;
	}

	public void setValorConta(BigDecimal valorConta) {
		this.valorConta = valorConta;
	}
	
	public Integer getTotalParcela() {
		return totalParcela;
	}

	public void setTotalParcela(Integer totalParcela) {
		this.totalParcela = totalParcela;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Parcela> getParcela() {
		return parcela;
	}
	
	public void setParcela(List<Parcela> parcela) {
		this.parcela = parcela;
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
		Conta other = (Conta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
