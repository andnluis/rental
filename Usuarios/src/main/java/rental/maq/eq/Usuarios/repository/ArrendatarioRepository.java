package rental.maq.eq.Usuarios.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import rental.maq.eq.Usuarios.model.Arrendatario;

import java.util.List;

public interface ArrendatarioRepository extends JpaRepository<Arrendatario,Integer> {


    Arrendatario findById(int id);
}
