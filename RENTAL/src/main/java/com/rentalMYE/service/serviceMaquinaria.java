package com.rentalMYE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalMYE.model.Maquinaria;
import com.rentalMYE.repository.RepositorioMaquina;



@Service

public class serviceMaquinaria {
	@Autowired
	RepositorioMaquina repositorioMaquina;
	
	//para crear una maquina nueva
	
	public void crearMaquina (Maquinaria maquina) {
		this.repositorioMaquina.save(maquina);
	}
	
	//para ver una lista de las maquinas 
	public List<Maquinaria> mostrarMaquinas (){
		
	return this.repositorioMaquina.findAll();
	}
	
	//para buscar una maquina en especifico
	
	public Maquinaria buscarMaquina (int id_maq) {
		
	return this.repositorioMaquina.findById(id_maq);
	
	}
	
	//-------------
	public List<Maquinaria> modeloMaquina (){
		
		return this.repositorioMaquina.findAll();
		}
	
public List<Maquinaria> tipoMaquina (){
		
		return this.repositorioMaquina.findAll();
		}

public List<Maquinaria> disponibleMaquina (){
	
	return this.repositorioMaquina.findAll();
	}
}

