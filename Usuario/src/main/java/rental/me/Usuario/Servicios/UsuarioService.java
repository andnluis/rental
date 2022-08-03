package rental.me.Usuario.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rental.me.Usuario.Repositorios.UsuarioRepositorio;
import rental.me.Usuario.modelos.Usuario;
import java.util.List;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usrrep;
    @Autowired
    CorreoService sercor;

    public void crearUsuario(Usuario usuario) {
        this.usrrep.save(usuario);
    }

    public List<Usuario> listarUsuarios(){return (List<Usuario>) this.usrrep.findAll();}


    public Usuario obtenerUsuario(int id){
        return this.usrrep.findById(id);
    }

<<<<<<< HEAD
    public List<Usuario> ExistenUsuariosEmail(String email){
        return this.usrrep.UsuariosByEmail(email);
    }
=======
    public Usuario obtenerUsuario(String email) {return this.usrrep.findByEmail(email);}
>>>>>>> login


    public void correoVerificacion(Usuario usr){
        String subject = "Porfavor, verifique su cuenta.";
        String content = "Estimado(a) Señor(a) "+usr.getNombre()+" "+usr.getApellido()+":\n\n";
        content += "Su código de verificación es el siguiente:\n";
        content += usr.getVerificacion()+"\n\n";
        content += "Tenga un buen día.";
        this.sercor.mandarCorreo(usr,subject,content);
    }

    public String verificarUsuario(String email, String codigo){
        Usuario user = obtenerUsuario(email);
        if(codigo.equals(user.getVerificacion())){
            usrrep.verficarUsuario(user.getId_usr());
            return "Verficiación exitosa";
        }else{
            return "verificacion fallida";
        }
    }

    public List<Usuario> listarPropietarios(){
        return (List<Usuario>) usrrep.listarPropietarios();
    }

    public List<Usuario> listarClientes(){
        return (List<Usuario>) usrrep.listarClientes();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Usuario user = usrrep.findByEmail(String username).orElseThrow(() -> new UsernameNotFoundException("Usuario no presente"));
            return user;
    }
}
