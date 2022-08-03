package rental.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.repository.RepositorioMaquina;

import rental.me.model.Maquina;


@Service
public class MaquinaServicio {
	@Autowired
	RepositorioMaquina repositorioMaquina;
	
	//para crear una maquina nueva
	
	public void crearMaquina (Maquina maquina) {
		this.repositorioMaquina.save(maquina);
	}
	
	//para ver una lista de las maquinas 
	public List<Maquina> mostrarMaquinas (){
	return (List<Maquina>) this.repositorioMaquina.findAll();
	}
	
	//para buscar una maquina en especifico
	
	public Maquina buscarMaquina (int id_maq) {
	return this.repositorioMaquina.findById(id_maq);
	}

	public List<Maquina> maquinasDeUsuario(int id){return  this.repositorioMaquina.maquinasDeUsuario(id);}

	public int cantidadMaquina(int id){return this.repositorioMaquina.cantidadMaquinas(id);}
	
	public List<Maquina> categoria (int id){return this.repositorioMaquina.filtrarCategoria(id);}
	public List<Maquina> sub (int id) {return this.repositorioMaquina.filtrarSubcategoria(id);}
	public List<Maquina> tipo (int id) {return this.repositorioMaquina.filtrarTipo(id);}

}

