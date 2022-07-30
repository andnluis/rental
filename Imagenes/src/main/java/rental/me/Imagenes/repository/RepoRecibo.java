package rental.me.Imagenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rental.me.Imagenes.model.Foto_recibo;

@Repository
public interface RepoRecibo extends JpaRepository<Foto_recibo,String> {

}
