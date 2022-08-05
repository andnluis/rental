package rental.me.Usuario;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rental.me.Usuario.Seguridad.JwtTokenProvider;
import rental.me.Usuario.Servicios.UsuarioService;
import rental.me.Usuario.modelos.Usuario;
import net.bytebuddy.utility.RandomString;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/usr")
@CrossOrigin(origins = "*")
public class Controlador {

    private static Logger log = LoggerFactory.getLogger(Controlador.class);

    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;


    @Autowired
    UsuarioService usuarioservice;


    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public ResponseEntity<String> crearPropietario(
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            @RequestParam(name = "telefono") int telefono,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave,
            @RequestParam(name = "tipo")Boolean prop
    ){
        log.info("conrolador : registro");
        JSONObject json = new JSONObject();
        try{
            String codigo = RandomString.make(6);
            String nm = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
            String ap = apellido.substring(0,1).toUpperCase() + apellido.substring(1).toLowerCase();
            LocalDateTime ahora = LocalDateTime.now();
            Usuario usr = new Usuario(nm,ap,telefono,email,clave,ahora,prop,false,codigo);
            usr.setClave(new BCryptPasswordEncoder().encode(usr.getClave()));
            usuarioservice.crearUsuario(usr);
            usuarioservice.correoVerificacion(usr);
            json.put("message", usr.getNombre() + " saved succesfully");
            return new ResponseEntity<>(json.toString(), HttpStatus.OK);
        }catch (JSONException e){
            try{
                json.put("exception", e.getMessage());
            }catch (JSONException el){
                el.printStackTrace();
            }
            return new ResponseEntity<String>(json.toString(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticate(@RequestBody Usuario user) {
        log.info("UserResourceImpl : authenticate");
        JSONObject jsonObject = new JSONObject();
        try {
            Authentication authentication = authenticationManager
                      .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getClave()));
            if (authentication.isAuthenticated()) {
                String email = user.getEmail();
                jsonObject.put("name", authentication.getName());
                jsonObject.put("authorities", authentication.getAuthorities());
                jsonObject.put("token", tokenProvider.createToken(email, usuarioservice.obtenerUsuario(email)));
                return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
            }
        } catch (JSONException e) {
            try {
                jsonObject.put("exception", e.getMessage());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
        return null;
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

    @RequestMapping(value = "/verificar", method = RequestMethod.PUT)
    public String verificarUsuario(@RequestParam(name = "email")String email, @RequestParam(name = "codigo") String codigo){
        return this.usuarioservice.verificarUsuario(email, codigo);
    }


}
