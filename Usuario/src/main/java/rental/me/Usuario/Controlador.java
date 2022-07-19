package rental.me.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rental.me.Usuario.Servicios.DireccionService;
import rental.me.Usuario.Servicios.UsuarioService;
import rental.me.Usuario.modelos.Direccion;
import rental.me.Usuario.modelos.Usuario;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controlador {

    @Autowired
    UsuarioService usuarioservice;

    @Autowired
    DireccionService direccionservice;

    @RequestMapping(value = "/usuario/propietario/add", method = RequestMethod.POST)
    public Usuario addUsuarioProp(
            @RequestParam(name = "n_id") String n_id,
            @RequestParam(name= "nombre") String nombre,
            @RequestParam(name= "apellido") String apellido,
            @RequestParam(name = "telefono") int telefono,
            @RequestParam(name = "direccion") String direccion,
            @RequestParam(name= "id_ciudad") int id_ciudad,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave,
            @RequestParam(name = "f_nac")Date f_nac
            ){
        Direccion direccion1 = new Direccion(direccion,id_ciudad);
        this.direccionservice.crearDireccion(direccion1);
        LocalDateTime ahora = LocalDateTime.now();
        Usuario usuario = new Usuario(n_id,nombre,apellido,telefono,direccion1,email,clave,f_nac,ahora,true);
        this.usuarioservice.crearUsuario(usuario);
        return usuario;
    }

    @RequestMapping(value = "/usuario/propietario/list", method = RequestMethod.GET)
    public List<Usuario> listarPropietarios(){
        return (List<Usuario>) this.usuarioservice.listarPropietario();
    }


    @RequestMapping(value = "/usuario/cliente/add", method = RequestMethod.POST)
    public Usuario addUsuarioCli(
            @RequestParam(name = "n_id") String n_id,
            @RequestParam(name= "nombre") String nombre,
            @RequestParam(name= "apellido") String apellido,
            @RequestParam(name = "telefono") int telefono,
            @RequestParam(name = "direccion") String direccion,
            @RequestParam(name= "id_ciudad") int id_ciudad,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave,
            @RequestParam(name = "f_nac")Date f_nac
    ){
        Direccion direccion1 = new Direccion(direccion, id_ciudad);
        this.direccionservice.crearDireccion(direccion1);
        LocalDateTime ahora = LocalDateTime.now();
        Usuario usuario = new Usuario(n_id,nombre,apellido,telefono,direccion1,email,clave,f_nac,ahora,false);
        this.usuarioservice.crearUsuario(usuario);
        return usuario;
    }


        @RequestMapping(value = "/usuario/cliente/list", method=RequestMethod.GET)
    public List<Usuario> listarCliente(){
        return this.usuarioservice.listarClientes();
    }

    @RequestMapping(value = "/usuario/buscar/departamento", method = RequestMethod.GET)
    public List<Usuario> buscarPorDepartamento(@RequestParam(name = "dept")int dept){
        return (List<Usuario>) this.usuarioservice.listarUsuarioPD(dept);
    }



}
