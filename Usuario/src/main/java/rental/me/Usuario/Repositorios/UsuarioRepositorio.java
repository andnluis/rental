package rental.me.Usuario.Repositorios;



import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rental.me.Usuario.modelos.Usuario;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer> {

    Usuario findById(int id);

    @Query(value = "select u from Usuario u where u.email = ?1")
    Optional<Usuario> findByEmail(String email);

    @Query(value = "select u from Usuario u where u.email = ?1")
    Usuario find1byEmaiil (String email);

    Boolean existsByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Usuario u set u.habilitado = 1 where u.id_usr =:id_usr")
    void verficarUsuario(@Param("id_usr") int id_usr);


    @Query(value = "select * from Usuario u where u.propietario = true", nativeQuery = true)
    List<Usuario> listarPropietarios();

    @Query(value = "select * from Usuario u where u.propietario = false", nativeQuery = true)
    List<Usuario> listarClientes();

    @Query(value="select * from usuario  where usuario.email = email",nativeQuery = true)
    List<Usuario> UsuariosByEmail(@Param("email") String email);

}
