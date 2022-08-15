package rental.me.Renta.repositorio;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rental.me.Renta.model.Renta;

import java.util.List;

@Repository
public interface RentaRepo extends CrudRepository<Renta,Integer> {

    @Query(value = "SELECT * FROM Renta WHERE id_arr = ?1 ORDER BY creado DESC LIMIT 1", nativeQuery = true)
    Renta encontrarRenta (int id_arr);

    @Query(value = "select u from Renta u where u.id_renta = ?1")
    Renta encontrarLaRenta(int id);

    @Query(value = "Select * from Renta where id_arr = ?1", nativeQuery = true)
    List<Renta> rentasPorUsuario(int id);
}
