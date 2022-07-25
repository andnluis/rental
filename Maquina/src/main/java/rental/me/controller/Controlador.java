package rental.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import rental.me.model.Maquina;
import rental.me.service.MaquinaServicio;

@RestController
public class Controlador {

	@Autowired
	MaquinaServicio sermaq;

	@RequestMapping (value="/maquina/add" , method = RequestMethod.POST )
	public Maquina crearMaquina(@RequestParam (name = "man") int id_man,
								@RequestParam (name = "prop") int id_prop,
								@RequestParam (name = "nserie") String nSerie,
								@RequestParam (name = "tdm") int idTipo,
								@RequestParam (name = "pph") float pph,
								@RequestParam (name = "ubi") int ubicacion,
								@RequestParam (name = "mdm") String modeloMotor,
								@RequestParam (name = "pot") float potencia,
								@RequestParam (name = "peso") float peso,
								@RequestParam (name = "des") String descripcion) {
		
		Maquina maq = new Maquina(id_man,id_prop,nSerie,true,idTipo,pph,ubicacion,modeloMotor,potencia,peso,descripcion);
		this.sermaq.crearMaquina(maq);
		return maq;
		
	}
	
	@RequestMapping (value="/maquina/list" , method = RequestMethod.GET )
	public List<Maquina> mostrarMaquinas (){
		return this.sermaq.mostrarMaquinas();
	}

}

	