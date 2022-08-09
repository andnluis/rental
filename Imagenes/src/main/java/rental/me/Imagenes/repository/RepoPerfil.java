package rental.me.Imagenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rental.me.Imagenes.model.Fotos_perfil;

@Repository
public interface RepoPerfil extends JpaRepository<Fotos_perfil, String> {

    @Query(value = "select uri from Fotos_perfil where id_usr = ?1 ")
    String getFile(int id_usr);
}
