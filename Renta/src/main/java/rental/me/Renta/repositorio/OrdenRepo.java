package rental.me.Renta.repositorio;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rental.me.Renta.model.Orden;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdenRepo extends CrudRepository<Orden,Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Orden o set o.fecha_final = ?2 where o.id_orden = ?1")
    void actualizarFechaInicio(int id_orden, LocalDateTime fecha_inicio);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Orden o set o.horas_rentadas = ?2 where o.id_orden = ?1")
    void actualizarHoras(int id_orden, int horas);

    @Query(value = "select o from Orden o where o.id_orden = ?1")
    Orden obtenerOrden(int id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE Orden SET fecha_final = ?2 where id_orden = ?1", nativeQuery = false)
    void actualizarFechaFinal(int id, LocalDateTime fecha_final);

    @Query(value = "Select orden.horas_rentadas * maquina.pph FROM orden inner join maquina on orden.id_maq = maquina.id_maq where orden.id_orden = ?1",
            nativeQuery = true)
    float subtotal ();


}
