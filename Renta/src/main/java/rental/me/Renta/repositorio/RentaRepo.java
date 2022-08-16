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

    @Query(value = "Select email from Usuario where id_usr = ?1", nativeQuery = true)
    String correodeArrendatario(int id);

    @Query(value = "Select SUM(orden.horas_rentadas * maquina.pph) FROM orden inner join maquina on orden.id_maq = maquina.id_maq where orden.id_renta = ?1",
            nativeQuery = true)
    float getTotal(int id_renta);

    @Query(value = "SELECT CONCAT(nombre, ' ', apellido) FROM usuario where id_usr = ?1", nativeQuery = true)
    String nombreArrendatario(int id_arr);


}
