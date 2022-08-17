package rental.me.Usuario.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rental.me.Usuario.Payload.Request.LoginRequest;
import rental.me.Usuario.Payload.Request.RegistroRequest;
import rental.me.Usuario.Payload.Response.JwtResponse;
import rental.me.Usuario.Payload.Response.MensajeRespuesta;
import rental.me.Usuario.Repositorios.RolRepositorio;
import rental.me.Usuario.Seguridad.Servicios.UserDetailsImpl;
import rental.me.Usuario.Seguridad.Servicios.UsuarioService;
import org.springframework.security.authentication.AuthenticationManager;
import rental.me.Usuario.Seguridad.jwt.JwtUtils;
import rental.me.Usuario.modelos.ERol;
import rental.me.Usuario.modelos.Rol;
import rental.me.Usuario.modelos.Usuario;
import net.bytebuddy.utility.RandomString;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usr")
@CrossOrigin(origins = "*")
public class Controlador {

    @Autowired
    UsuarioService usrser;

    @Autowired
    RolRepositorio rolrep;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroRequest solicitud){
        if(usrser.existeUsuario(solicitud.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MensajeRespuesta("Error: El correo ya esta siendo utilizado por otro usuario"));
        }
        String codigo = RandomString.make(6);
        String nm = solicitud.getNombre().substring(0,1).toUpperCase() + solicitud.getNombre().substring(1).toLowerCase();
        String ap = solicitud.getApellido().substring(0,1).toUpperCase() + solicitud.getApellido().substring(1).toLowerCase();
        LocalDateTime ahora = LocalDateTime.now();
        Usuario user = new Usuario(nm,ap,solicitud.getTelefono(),solicitud.getEmail(),new BCryptPasswordEncoder().encode(solicitud.getClave()),ahora,false,codigo);

        Set<String> strRoles = Collections.singleton(solicitud.getRol());
        Set<Rol> roles = new HashSet<>();

        if(strRoles == null){
            Rol rol_usuario = rolrep.findByNombre(ERol.ROL_CLIENTE)
                    .orElseThrow( () -> new RuntimeException("Error: Rol no encontrado"));
            roles.add(rol_usuario);
        }else{
            strRoles.forEach( role -> {
                switch (role) {
                    case "prop":
                        Rol proprol = rolrep.findByNombre(ERol.ROL_PROPIETARIO)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(proprol);
                        break;
                    case "cli" :
                        Rol clirol = rolrep.findByNombre(ERol.ROL_CLIENTE)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(clirol);
                        break;
                    default:
                        Rol usclirol = rolrep.findByNombre(ERol.ROL_CLIENTE)
                                .orElseThrow(()-> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(usclirol);
                        break;
                }
            });
        }

        user.setRoles(roles);
        usrser.correoVerificacion(user);
        usrser.crearUsuario(user);

        return ResponseEntity.ok(new MensajeRespuesta("Usuario registrado correctamente"));

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> AutenticarUsuario (@RequestBody LoginRequest login) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getClave())
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtUtils.generateJwtToken(auth);

        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                (long) userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles
                ));
    }

    @RequestMapping(value = "/google/ask", method = RequestMethod.POST)
    public boolean comprobarUsuarioGoogle (
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave
    ){
        if(usrser.ExistenUsuariosEmail(email).isEmpty()){
            System.out.println("El usuario aun no existe");
            return false;
        }else{
            System.out.println("El usuario ya existe");
            return true;
        }
    }

    @RequestMapping(value = "/google/add2", method = RequestMethod.POST)
    public Usuario crearUsuarioGoogle2 (
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            @RequestParam(name = "telefono") int telefono,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "clave") String clave

    ){
        String nm = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        String ap = apellido.substring(0,1).toUpperCase() + apellido.substring(1).toLowerCase();
        LocalDateTime ahora = LocalDateTime.now();
        Usuario usr = new Usuario(nm,ap,telefono,email,clave,ahora,true,"google");
        usrser.crearUsuario(usr);
        return usr;
    }
    @PostMapping("/google/add")
    public ResponseEntity<?> crearUsuarioGoogle(@RequestBody RegistroRequest solicitud){
        if(usrser.existeUsuario(solicitud.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MensajeRespuesta("Error: El correo ya esta siendo utilizado por otro usuario"));
        }
        String codigo = "google";
        String nm = solicitud.getNombre().substring(0,1).toUpperCase() + solicitud.getNombre().substring(1).toLowerCase();
        String ap = solicitud.getApellido().substring(0,1).toUpperCase() + solicitud.getApellido().substring(1).toLowerCase();
        LocalDateTime ahora = LocalDateTime.now();
        Usuario user = new Usuario(nm,ap,solicitud.getTelefono(),solicitud.getEmail(),new BCryptPasswordEncoder().encode(solicitud.getClave()),ahora,false,codigo);

        Set<String> strRoles = Collections.singleton(solicitud.getRol());
        Set<Rol> roles = new HashSet<>();

        if(strRoles == null){
            Rol rol_usuario = rolrep.findByNombre(ERol.ROL_CLIENTE)
                    .orElseThrow( () -> new RuntimeException("Error: Rol no encontrado"));
            roles.add(rol_usuario);
        }else{
            strRoles.forEach( role -> {
                switch (role) {
                    case "prop":
                        Rol proprol = rolrep.findByNombre(ERol.ROL_PROPIETARIO)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(proprol);
                        break;
                    case "cli" :
                        Rol clirol = rolrep.findByNombre(ERol.ROL_CLIENTE)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(clirol);
                        break;
                    default:
                        Rol usclirol = rolrep.findByNombre(ERol.ROL_CLIENTE)
                                .orElseThrow(()-> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(usclirol);
                        break;
                }
            });
        }

        user.setRoles(roles);
        usrser.crearUsuario(user);
        System.out.println(user);
        return ResponseEntity.ok(new MensajeRespuesta("Usuario registrado correctamente"));

    }

    @PutMapping(value = "/verificar")
    public String verificarUsuario(@RequestParam(name = "email")String email, @RequestParam(name = "codigo") String codigo){
        return this.usrser.verificarUsuario(email, codigo);
    }

    @GetMapping(value = "/list")
    public List<Usuario> listarTodos(){
        return (List<Usuario>) this.usrser.listarUsuarios();
    }





}
