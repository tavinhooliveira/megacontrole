package com.megas.controle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megas.controle.model.Conta;

public interface Contas extends JpaRepository<Conta, Long> {
			
	public List<Conta> findByDescricaoContaining(String descricao);
		
	 @Query("SELECT count(codigo) FROM Conta c WHERE c.tipoConta = 'DESPESA'")
	    public List<Conta> findByTipoContaDESPESA();
	 
	 @Query("SELECT count(codigo) FROM Conta c WHERE c.tipoConta = 'RECEITA'")
	    public List<Conta> findByTipoContaRECEITA();
	 
	 @Query(value = "SELECT * FROM conta where data_vencimento < CURRENT_DATE ORDER BY data_vencimento DESC limit 3", nativeQuery = true)
	 	public List<Conta> findByCodigo();
	 
	 @Query("SELECT COUNT(codigo) as Qtde FROM Conta c where dataVencimento < CURRENT_DATE")
	    public List<Conta> findByCodigoAtrasado();
	 	 	 
	 @Query(value = "SELECT * FROM conta ORDER BY CURRENT_DATE asc limit 5", nativeQuery = true)
	 	public List<Conta> findByCodigoUltimos();
	 
	 @Query(value = "SELECT * FROM conta where data_vencimento = CURRENT_DATE and status <> 'PAGO' ORDER BY data_vencimento DESC limit 3", nativeQuery = true)
	 	public List<Conta> findByCodigoUltimosVencimentoHoje();
	 
	 @Query("SELECT COUNT(codigo) as Qtde FROM Conta c where dataVencimento = CURRENT_DATE and status <> 'PAGO'")
	    public List<Conta> findByCodigoAtrasadoQuant();
	 	 
	 @Query("SELECT SUM(valorConta) FROM Conta c WHERE c.tipoConta = 'RECEITA'")
	    public List<Conta> findByValoContaRECEITAvalor();
	 	 
	 @Query("SELECT SUM(valorConta) FROM Conta c WHERE c.tipoConta = 'DESPESA'")
	    public List<Conta> findByValoContaDESPESAvalor();
	 
	 
}

