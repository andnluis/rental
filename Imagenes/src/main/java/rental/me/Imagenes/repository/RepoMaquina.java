package rental.me.Imagenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rental.me.Imagenes.model.Fotos_maq;

@Repository
public interface RepoMaquina extends JpaRepository<Fotos_maq, String> {

    @Query(value = "select uri from Fotos_maq where id_maq = ?1 ")
    String getFile(int id_maq);


}
