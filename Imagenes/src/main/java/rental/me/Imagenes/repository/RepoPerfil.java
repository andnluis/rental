package rental.me.Imagenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rental.me.Imagenes.model.Fotos_perfil;

@Repository
public interface RepoPerfil extends JpaRepository<Fotos_perfil, String> {

}
