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

	public List<Maquina> manufacturador(int id){return this.repositorioMaquina.maquinasManufacturador(id);}

	public List<Maquina> ciudad(int id){return this.repositorioMaquina.maquinaCiudad(id);}

	public List<Maquina> departamento(int id){return this.repositorioMaquina.maquinaDept(id);}

	public List<Maquina> listadoDinamico(int ciudad_id,int categoria_id,int manofacturador_id) {

		if (ciudad_id==-1&&categoria_id==-1&&manofacturador_id==-1){
			return (List<Maquina>)this.repositorioMaquina.findAll();
		}else if(ciudad_id==-1&&categoria_id==-1&&manofacturador_id!=-1){
			return this.repositorioMaquina.maquinasManufacturador(manofacturador_id);
		}else if (ciudad_id==-1&&categoria_id!=-1&&manofacturador_id==-1){
			return this.repositorioMaquina.filtrarCategoria(categoria_id);
		} else if (ciudad_id!=-1&&categoria_id==-1&&manofacturador_id==-1) {
			return this.repositorioMaquina.maquinaCiudad(ciudad_id);
		} else if (ciudad_id!=-1&&categoria_id!=-1&&manofacturador_id==-1){
			return this.repositorioMaquina.maquinaCuidadCategoria(ciudad_id,categoria_id);
		}else if (ciudad_id!=-1&&categoria_id==-1&&manofacturador_id!=-1){
			return this.repositorioMaquina.maquinaCuidadManofacturador(ciudad_id,manofacturador_id);
		}else if (ciudad_id==-1&&categoria_id!=-1&&manofacturador_id!=-1){
			return this.repositorioMaquina.maquinaCategoriaManofacturador(categoria_id,manofacturador_id);
		}else {
			return this.repositorioMaquina.maquinaDinamica(ciudad_id,categoria_id,manofacturador_id);
		}


	}

}

