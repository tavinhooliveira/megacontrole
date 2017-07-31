package com.megas.controle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megas.controle.model.Pessoa;

public interface Pessoas extends JpaRepository<Pessoa,Long> {
	
	public List<Pessoas> findBynomePessoaContaining (String nomePessoa);
	
	public Optional<Pessoas> findBynomePessoaIgnoreCase (String nomePessoa);
	
	
		

}
