package rental.me.Usuario.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rental.me.Usuario.modelos.ERol;
import rental.me.Usuario.modelos.Rol;

import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol,Integer> {

    Optional<Rol> findByNombre(ERol nombre);
}
