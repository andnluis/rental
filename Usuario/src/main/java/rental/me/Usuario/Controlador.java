package rental.me.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rental.me.Usuario.Servicios.UsuarioService;
import rental.me.Usuario.modelos.Usuario;
import net.bytebuddy.utility.RandomString;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controlador {

    @Autowired
    UsuarioService usuarioservice;

    @RequestMapping(value = "/usr/pr/add", method = RequestMethod.POST)
    public Usuario crearPropietario(
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            @RequestParam(name = "telefono") int telefono,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave
    ){
        String codigo = RandomString.make(6);
        String nm = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        String ap = apellido.substring(0,1).toUpperCase() + apellido.substring(1).toLowerCase();
        LocalDateTime ahora = LocalDateTime.now();
        Usuario usr = new Usuario(nm,ap,telefono,email,clave,ahora,true,false,codigo);
        usuarioservice.crearUsuario(usr);
        usuarioservice.correoVerificacion(usr);
        return usr;
    }

    @RequestMapping(value = "/usr/pr/list", method = RequestMethod.GET)
    public List<Usuario> listarPropietarios(){
        return (List<Usuario>) usuarioservice.listarPropietarios();
    }

    @RequestMapping(value = "/usr/cl/add", method = RequestMethod.POST)
    public Usuario crearCliente(
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            @RequestParam(name = "telefono") int telefono,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave
    ){
        String codigo = RandomString.make(6);
        String nm = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        String ap = apellido.substring(0,1).toUpperCase() + apellido.substring(1).toLowerCase();
        LocalDateTime ahora = LocalDateTime.now();
        Usuario usr = new Usuario(nm,ap,telefono,email,clave,ahora,false,false,codigo);
        usuarioservice.crearUsuario(usr);
        usuarioservice.correoVerificacion(usr);
        return usr;
    }
    @RequestMapping(value = "/usr/google/ask", method = RequestMethod.POST)
    public boolean comprobarUsuarioGoogle (
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave
    ){
        if(usuarioservice.ExistenUsuariosEmail(email).size()==0){
            System.out.println("El usuario aun no existe");
            return false;
        }else{
            System.out.println("El usuario ya existe");
            return true;
        }
    }

    @RequestMapping(value = "/usr/google/add", method = RequestMethod.POST)
    public Usuario crearUsuarioGoogle (
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            @RequestParam(name = "telefono") int telefono,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave

    ){
        String nm = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        String ap = apellido.substring(0,1).toUpperCase() + apellido.substring(1).toLowerCase();
        LocalDateTime ahora = LocalDateTime.now();
        Usuario usr = new Usuario(nm,ap,telefono,email,clave,ahora,false,true,"google");
        usuarioservice.crearUsuario(usr);
        return usr;
    }

    @RequestMapping(value = "/usr/cl/list", method = RequestMethod.GET)
    public List<Usuario> listarClientes(){
        return (List<Usuario>) usuarioservice.listarClientes();
    }


    @RequestMapping(value = "/usr/list", method = RequestMethod.GET)
    public List<Usuario> listarTodos(){
        return (List<Usuario>) this.usuarioservice.listarUsuarios();
    }


    @RequestMapping(value = "/usr/get", method = RequestMethod.GET)
    public Usuario obtenerUsuario(@RequestParam(name = "id")int id_usr){
        return this.usuarioservice.obtenerUsuario(id_usr);
    }

    @RequestMapping(value = "/usr/verificar", method = RequestMethod.PUT)
    public String verificarUsuario(@RequestParam(name = "id") int id, @RequestParam(name = "codigo") String codigo){
        return this.usuarioservice.verificarUsuario(id, codigo);
    }


}
