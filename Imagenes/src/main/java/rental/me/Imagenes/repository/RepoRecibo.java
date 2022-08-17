package rental.me.Imagenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rental.me.Imagenes.model.Foto_recibo;

import javax.transaction.Transactional;

@Repository
public interface RepoRecibo extends JpaRepository<Foto_recibo,String> {


    @Query(value = "select uri from Foto_recibo where id_renta = ?1 ")
    String getFile(int id_renta);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE Renta set cancelado = 1 where id_renta = ?1", nativeQuery = true)
    void varlidarRecibo(int id_renta);

}
