package rental.me.Usuario.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rental.me.Usuario.Repositorios.UsuarioRepositorio;
import rental.me.Usuario.modelos.Usuario;

import javax.mail.internet.MimeMessage;
import javax.swing.text.html.Option;
import javax.tools.JavaFileManager;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

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


    public void correoVerificacion(Usuario usr){
        String subject = "Porfavor, verifique su cuenta.";
        String content = "Estimado(a) Señor(a) "+usr.getNombre()+" "+usr.getApellido()+":\n\n";
        content += "Su código de verificación es el siguiente:\n";
        content += usr.getVerificacion()+"\n\n";
        content += "Tenga un buen día.";
        this.sercor.mandarCorreo(usr,subject,content);
    }

    public String verificarUsuario(int id, String codigo){
        Usuario user = obtenerUsuario(id);
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


}
