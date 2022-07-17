package com.rentalMYE.model;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "Maquina")
public class Maquinaria {
	@Id
	private int id_maq;
	private int id_man;
	private int id_prop;
	private String nSerie;
	private Image foto;
	private boolean disponible; 
	private int idTipo;
	private float pph;
	private int ubicacion ;
	private String modeloMotor;
	private float potencia;
	private float peso;
	private String descripcion;
	
	
	
	public Maquinaria () {}	
	
	
	
	public Maquinaria(int id_maq, int id_man, int id_prop, String nSerie, Image foto, boolean disponible, int idTipo,
			float pph, int ubicacion, String modeloMotor, float potencia, float peso, String descripcion) {
		super();
		this.id_maq = id_maq;
		this.id_man = id_man;
		this.id_prop = id_prop;
		this.nSerie = nSerie;
		this.foto = foto;
		this.disponible = disponible;
		this.idTipo = idTipo;
		this.pph = pph;
		this.ubicacion = ubicacion;
		this.modeloMotor = modeloMotor;
		this.potencia = potencia;
		this.peso = peso;
		this.descripcion = descripcion;
	}



	
	public int getId_maq() {
		return id_maq;
	}
	public void setId_maq(int id_maq) {
		this.id_maq = id_maq;
	}
	public int getId_man() {
		return id_man;
	}
	public void setId_man(int id_man) {
		this.id_man = id_man;
	}
	public int getId_prop() {
		return id_prop;
	}
	public void setId_prop(int id_prop) {
		this.id_prop = id_prop;
	}
	public String getnSerie() {
		return nSerie;
	}
	public void setnSerie(String nSerie) {
		this.nSerie = nSerie;
	}
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public float getPph() {
		return pph;
	}
	public void setPph(float pph) {
		this.pph = pph;
	}
	public int getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getModeloMotor() {
		return modeloMotor;
	}
	public void setModeloMotor(String modeloMotor) {
		this.modeloMotor = modeloMotor;
	}
	public float getPotencia() {
		return potencia;
	}
	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	


	
	
	
	
	
	
	
}
