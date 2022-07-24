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
            @RequestParam(name = "n_id", required = false) String n_id,
            @RequestParam(name= "nombre", required = false) String nombre,
            @RequestParam(name= "apellido", required = false) String apellido,
            @RequestParam(name = "telefono", required = false) int telefono,
            @RequestParam(name = "direccion", required = false) String direccion,
            @RequestParam(name= "id_ciudad") String id_ciudad,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "clave", required = false) String clave,
            @RequestParam(name = "f_nac", required = false)Date f_nac
            ){
        int ciudad = Integer.parseInt(id_ciudad);
        Direccion direccion1 = new Direccion(direccion,ciudad);
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
            @RequestParam(name = "telefono") String telefono,
            @RequestParam(name = "direccion") String direccion,
            @RequestParam(name= "id_ciudad") String id_ciudad,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave,
            @RequestParam(name = "f_nac")Date f_nac
    ){
        int ciudad = Integer.parseInt(id_ciudad);
        int tel = Integer.parseInt(telefono);
        Direccion direccion1 = new Direccion(direccion, ciudad);
        this.direccionservice.crearDireccion(direccion1);
        LocalDateTime ahora = LocalDateTime.now();
        Usuario usuario = new Usuario(n_id,nombre,apellido,tel,direccion1,email,clave,f_nac,ahora,false);
        this.usuarioservice.crearUsuario(usuario);
        return usuario;
    }


        @RequestMapping(value = "/usuario/cliente/list", method=RequestMethod.GET)
    public List<Usuario> listarCliente(){
        return this.usuarioservice.listarClientes();
    }

    @RequestMapping(value = "/usuario/buscar/departamento", method = RequestMethod.GET)
    public List<Usuario> buscarPorDepartamento(@RequestParam(name = "dept", required = false)int dept){
        return (List<Usuario>) this.usuarioservice.listarUsuarioPD(dept);
    }



}
