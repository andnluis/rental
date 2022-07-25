package rental.me.Usuario.Repositorios;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rental.me.Usuario.modelos.Usuario;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer> {

    Usuario findById(int id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Usuario u set u.habilitado = 1 where u.id_usr =:id_usr")
    void verficarUsuario(@Param("id_usr") int id_usr);

    @Query("select * from Usuario u where u.propietario = true")
    List<Usuario> listarPropietarios();

    @Query("select * from Usuario u where u.propietario = false")
    List<Usuario> listarClientes();

}
