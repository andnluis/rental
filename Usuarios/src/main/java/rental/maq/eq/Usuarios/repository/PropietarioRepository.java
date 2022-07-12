package rental.maq.eq.Usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import rental.maq.eq.Usuarios.model.Propietario;

import java.util.List;

public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {


    Propietario findById(int id);

}
