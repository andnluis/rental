package rental.maq.eq.Usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rental.maq.eq.Usuarios.model.Direccion;

import java.util.List;

public interface DireccionRepository extends JpaRepository<Direccion,Integer> {


    Direccion findById(int id);
}
