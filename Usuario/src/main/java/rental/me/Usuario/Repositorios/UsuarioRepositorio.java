package rental.me.Usuario.Repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rental.me.Usuario.modelos.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer> {

    @Query(value = "select u from Usuario u where u.propietario=false")
    List<Usuario> listarCliente();

    @Query(value = "select u from Usuario u where u.propietario=true")
    List<Usuario> listarPropietario();

    @Query(value = "select * from usuario inner join direccion on direccion.id_dir = usuario.id_dir inner join ciudad on ciudad.id_ciudad = direccion.id_ciudad inner join \n" +
            "departamento on departamento.id_dep = ciudad.id_dep where departamento.id_dep = ?1", nativeQuery = true)
    List<Usuario> listUsuarioPD(int departamento);
}
