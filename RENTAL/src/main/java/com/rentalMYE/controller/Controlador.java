package com.rentalMYE.controller;

import java.awt.Image;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalMYE.model.Maquinaria;
import com.rentalMYE.service.serviceMaquinaria;

@RestController
public class Controlador {

	@Autowired
	serviceMaquinaria ServiceMaquinaria;
	



	@RequestMapping (value="/maquinaria/crearMaquina" , method = RequestMethod.GET )
	public Maquinaria crearMaquina(@RequestParam (name = " id") int id_maq,
									@RequestParam (name = " id_man") int id_man,
									@RequestParam (name = "id_propietario") int id_prop,
									@RequestParam (name = "numero de serie") String nSerie,
									@RequestParam (name = "imagen") Image foto,
									@RequestParam (name = "disponibilidad") boolean disponible,
									@RequestParam (name = "tipo de maquina") int idTipo,
									@RequestParam (name = "pph") float pph,
									@RequestParam (name = "ubicacion") int ubicacion,
									@RequestParam (name = "modelo del motor") String modeloMotor,
									@RequestParam (name = "potencia") float potencia,
									@RequestParam (name = "peso soportado") float peso,
									@RequestParam (name = "descripcion") String descripcion) {
		
		Maquinaria maquinaria = new Maquinaria(id_maq, id_man, id_prop, nSerie, foto, disponible, idTipo, pph, ubicacion,
												modeloMotor, potencia, peso, descripcion);
		
		this.ServiceMaquinaria.crearMaquina(maquinaria);
		return maquinaria;
		
	}
	
	@RequestMapping (value="/maquinaria/mostrarMaquinas" , method = RequestMethod.GET )
	public List<Maquinaria> mostrarMaquinas (){
		
	return this.ServiceMaquinaria.mostrarMaquinas();
		
	}
	
	@RequestMapping (value="/maquinaria/buscarMaquina" , method = RequestMethod.GET )
	public Maquinaria buscarMaquina (int id_maq) {
	return this.ServiceMaquinaria.buscarMaquina(id_maq);
		
	}
	
	@Query(value = "select  modeloMotor from Maquina limit ?1", nativeQuery = true)
	List<Maquinaria> getLimitedData(String modeloMotor ) {
		return this.ServiceMaquinaria.modeloMaquina();
	}
	

	@Query(value = "select  idTipo from Maquina limit ?1", nativeQuery = true)
	List<Maquinaria> getLimitedData( int idTipo) {
		return this.ServiceMaquinaria.tipoMaquina();
	}
	
	@Query(value = "select  disponible from Maquina limit ?1", nativeQuery = true)
	List<Maquinaria> getLimitedData(boolean disponible) {
		return this.ServiceMaquinaria.disponibleMaquina();
	}
}

	