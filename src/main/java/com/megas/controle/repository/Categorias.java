package com.megas.controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megas.controle.model.Categoria;

public interface Categorias extends JpaRepository<Categoria, Long> {

}
