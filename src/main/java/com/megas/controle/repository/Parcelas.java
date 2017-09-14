package com.megas.controle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megas.controle.model.Parcela;

public interface Parcelas extends JpaRepository<Parcela, Long> {
	
	public List<Parcela> findByDescricaoParcelaContaining(String DescricaoParcela);
		
	 	@Query("SELECT SUM(valorParcela) FROM Parcela ")
	    public List<Parcela> findByValorParcelaQTA();
	 	
	 	@Query("SELECT COUNT(c.codigo) FROM Conta c where c.formaPagamento = 'PARCELADO'")
	    public List<Parcela> findByValorParcelaCONT();
	 	
//	 	@Query(value = "SELECT SUM(valorParcela) FROM Parcela", nativeQuery = true)
//	 	public List<Parcela> findByValorContaParcelada();
//	
	 	@Query("SELECT SUM(valorParcela) FROM Parcela")
	    public List<Parcela> findByValorContaParcelada();

}
