package rental.maq.eq.Usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rental.maq.eq.Usuarios.model.Arrendatario;
import rental.maq.eq.Usuarios.model.Direccion;
import rental.maq.eq.Usuarios.model.Propietario;
import rental.maq.eq.Usuarios.service.ServicioArrendatario;
import rental.maq.eq.Usuarios.service.ServicioDireccion;
import rental.maq.eq.Usuarios.service.ServicioPropietario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
public class Controlador {

    @Autowired
    ServicioArrendatario sar;
    @Autowired
    ServicioPropietario spro;
    @Autowired
    ServicioDireccion sdir;

    @RequestMapping(value = "/direccion/add", method = RequestMethod.GET)
    public Direccion crearDireccion(
            @RequestParam(name = "direccion") String direccion,
            @RequestParam(name = "ciudad") int ciudad
    ){
        Direccion dir = new Direccion(direccion, ciudad);
        this.sdir.crearDireccion(dir);
        return dir;
    }

   @RequestMapping(value = "/propietario/add", method = RequestMethod.GET)
    public Propietario crearPropietario(
                @RequestParam(name="n_id") String n_id,
                @RequestParam(name = "nombre")String nombre,
                @RequestParam(name="apellido")String apellido,
                @RequestParam(name="telefono")int telefono,
                @RequestParam(name="direccion") String direccion,
                @RequestParam(name="ciudad")int ciudad,
                @RequestParam(name="email")String email,
                @RequestParam(name="clave")String clave,
                @RequestParam(name="fnac") Date fecha,
                @RequestParam(name="foto") byte[] foto
        ){
        Direccion dd = crearDireccion(direccion,ciudad);
       LocalDateTime ahora = LocalDateTime.now();
       Propietario pp = new Propietario(n_id,nombre,apellido,telefono,dd,email,clave,fecha,ahora,foto);
       this.spro.crearPropietario(pp);
       return pp;
    }

    @RequestMapping(value = "/propietario/list")
    public List<Propietario> listarPropietarios(){
        return this.spro.obtenerPropietarios();
    }

    @RequestMapping(value = "/arrendatario/add", method = RequestMethod.GET)
    public Arrendatario crearArrendatario(
            @RequestParam(name = "n_id") String n_id,
            @RequestParam(name="nombre") String nombre,
            @RequestParam(name="apellido")String apellido,
            @RequestParam(name="telefono")int telefono,
            @RequestParam(name="direccion")String direccion,
            @RequestParam(name="ciudad")int ciudad,
            @RequestParam(name="email")String email,
            @RequestParam(name="clave")String clave,
            @RequestParam(name="foto")byte[] pfp
    ){
        Direccion dd = crearDireccion(direccion,ciudad);
        LocalDateTime ahora = LocalDateTime.now();
        Arrendatario arr = new Arrendatario(n_id, nombre, apellido,telefono, dd, email, clave, ahora, pfp);
        this.sar.crearArr(arr);
        return arr;
    }

    @RequestMapping(value = "/arrendatario/list")
    public List<Arrendatario> listarArrendatarios(){
        return this.sar.getArrendatarios();
    }


}
