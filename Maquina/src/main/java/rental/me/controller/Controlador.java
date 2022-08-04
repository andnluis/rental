package rental.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import rental.me.model.Maquina;
import rental.me.service.MaquinaServicio;

@RestController
@RequestMapping(value = "/maquina")
public class Controlador {

	@Autowired
	MaquinaServicio sermaq;

	@RequestMapping (value="/add" , method = RequestMethod.POST )
	public Maquina crearMaquina(@RequestParam (name = "man") int id_man,
								@RequestParam (name = "prop") int id_prop,
								@RequestParam (name = "nserie") String nSerie,
								@RequestParam (name = "tdm") int idTipo,
								@RequestParam (name = "pph") float pph,
								@RequestParam (name = "ubi") int ubicacion,
								@RequestParam (name = "mdm") String modeloMotor,
								@RequestParam (name = "pot") float potencia,
								@RequestParam (name = "peso") float peso) {
		
		Maquina maq = new Maquina(id_man,id_prop,nSerie,true,idTipo,pph,ubicacion,modeloMotor,potencia,peso);
		this.sermaq.crearMaquina(maq);
		return maq;
		
	}
	
	@RequestMapping (value="/list" , method = RequestMethod.GET )
	public List<Maquina> mostrarMaquinas (){
		return this.sermaq.mostrarMaquinas();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public Maquina buscar(@RequestParam(name = "id")int id){
		return this.sermaq.buscarMaquina(id);
	}

	@RequestMapping(value = "/prop", method = RequestMethod.GET)
	public List<Maquina> maquinasDeUsuario(@RequestParam(name = "id")int id){
		return this.sermaq.maquinasDeUsuario(id);
	}

	@RequestMapping(value = "/prop/cant", method = RequestMethod.GET)
	public int cantidadUsuario(@RequestParam(name = "id")int id){
		return this.sermaq.cantidadMaquina(id);
	}

	@RequestMapping(value = "/cat", method = RequestMethod.GET)
	public List<Maquina> filtroCat (@RequestParam(value = "cat")int id){return this.sermaq.categoria(id);}
	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public List<Maquina> filtroSub (@RequestParam(value = "sub")int id){return this.sermaq.sub(id);}
	@RequestMapping(value = "/tipo", method = RequestMethod.GET)
	public List<Maquina> filtroTipo (@RequestParam(value = "tipo")int id){return this.sermaq.tipo(id);}

	@RequestMapping(value = "/man", method = RequestMethod.GET)
	public List<Maquina> obtenerMarca(@RequestParam(value = "man")int id){
		return this.sermaq.manufacturador(id);
	}

	@RequestMapping(value = "/ub/ciudad", method = RequestMethod.GET)
	public List<Maquina> maquinasCiudad(@RequestParam(value = "ciudad")int id){
		return this.sermaq.ciudad(id);
	}

	@RequestMapping(value = "/ub/dep", method = RequestMethod.GET)
	public List<Maquina> maquinadDepartamento(@RequestParam(value = "dep")int id){
		return this.sermaq.departamento(id);
	}


}

	