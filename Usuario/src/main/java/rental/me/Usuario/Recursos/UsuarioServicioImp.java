package rental.me.Usuario.Recursos;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import rental.me.Usuario.Repositorios.UsuarioRepositorio;
import rental.me.Usuario.modelos.Usuario;

import java.util.Collection;
import java.util.Optional;

public class UsuarioServicioImp implements IService<Usuario> {

    @Autowired
    UsuarioRepositorio usrrep;

    @Override
    public Collection<Usuario> findAll() {
        return (Collection<Usuario>) usrrep.findAll();
    }


    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(usrrep.findById(Math.toIntExact(id)));
    }

    @Override
    public Usuario saveOrUpdate(Usuario usuario) {
        return usrrep.save(usuario);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            usrrep.deleteById(Math.toIntExact(id));
            jsonObject.put("message", "User deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
