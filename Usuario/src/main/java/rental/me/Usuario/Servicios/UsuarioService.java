package rental.me.Usuario.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import rental.me.Usuario.Repositorios.UsuarioRepositorio;
import rental.me.Usuario.modelos.Usuario;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio usrrep;

    public void crearUsuario(Usuario usuario){
        this.usrrep.save(usuario);
    }

    public List<Usuario> listarUsuarios(){return (List<Usuario>) this.usrrep.findAll();}

    public List<Usuario> listarClientes(){return (List<Usuario>) this.usrrep.listarCliente();}

    public List<Usuario> listarPropietario(){return(List<Usuario>) this.usrrep.listarPropietario();}

    public List<Usuario> listarUsuarioPD(int departamento){
        return (List<Usuario>) this.usrrep.listUsuarioPD(departamento);
    }


}
