package com.rentalMYE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalMYE.model.Maquinaria;

public interface RepositorioMaquina extends JpaRepository<Maquinaria, Integer>{

	public Maquinaria findById (int id_maq);
	
}
