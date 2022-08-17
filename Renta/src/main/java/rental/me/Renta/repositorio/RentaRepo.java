package rental.me.Renta.repositorio;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rental.me.Renta.model.Renta;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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


    //Retorna el total de dinero que se ha ganado en la pagina
    @Query(value = "SELECT ROUND(SUM(maquina.pph * orden.horas_rentadas),2) from orden inner join renta on orden.id_renta = renta.id_renta " +
            "inner join maquina on maquina.id_maq = orden.id_maq inner join usuario on maquina.id_prop = usuario.id_usr where renta.cancelado = 1" +
            " and usuario.id_usr = ?1", nativeQuery = true)
    float totaldineroUsuario(int id_usr);


    @Query(value = "SELECT ROUND(SUM(maquina.pph * orden.horas_rentadas),2) from orden inner join renta on orden.id_renta = renta.id_renta " +
            "inner join maquina on maquina.id_maq = orden.id_maq inner join usuario on maquina.id_prop = usuario.id_usr" +
            " where renta.cancelado = 1 and maquina.id_maq = ?1", nativeQuery = true)
    float totaldineroMaquina(int id_maq);

    @Query(value = "Select count(orden.id_maq) from orden inner join renta on orden.id_renta = renta.id_renta where renta.cancelado = 1 and orden.id_maq = ?1",
                    nativeQuery = true)
    int vecesMaquinaRentada(int id_maq);

    @Query(value = "SELECT orden.id_maq from orden inner join renta on orden.id_renta = renta.id_renta where " +
            "renta.cancelado = 1 group by orden.id_maq order by count(orden.id_maq) desc limit 3", nativeQuery = true)
    List<Integer> top3maquinas ();

    @Query(value = "SELECT orden.id_maq from orden inner join renta on orden.id_renta = renta.id_renta inner join maquina on maquina.id_maq = orden.id_maq" +
            "inner join usuario on maquina.id_prop = usuario.id_usr where renta.cancelado = 1 and usuario.id_usr = ?1" +
            "group by orden.id_maq" +
            "order by count(orden.id_maq) desc limit 3", nativeQuery = true)
    List<Integer> top3maquinasporusuario(int id_usr);

   @Query(value = "SELECT orden.id_maq from orden inner join renta on orden.id_renta = renta.id_renta inner join maquina on maquina.id_maq = orden.id_maq where" +
           " renta.cancelado = 1 and month(renta.creado) = ?2 and year(renta.creado) = year(curdate()) and maquina.id_prop = ?1" +
           " group by orden.id_maq order by count(orden.id_maq) desc", nativeQuery = true)
    List<Integer> maquinapormes(int id_usr, int mes);

   @Query(value = "SELECT  distinct(orden.fecha_final) from orden inner join renta on orden.id_renta = renta.id_renta inner join maquina on maquina.id_maq = orden.id_maq \n" +
           "inner join usuario on maquina.id_prop = usuario.id_usr where renta.cancelado = 1 and maquina.disponible = 0 and maquina.id_maq = ?1", nativeQuery = true)
   LocalDateTime fechadeRetorno(int id_maq);

   @Query(value = "SELECT maquina.id_maq FROM maquina inner join usuario on usuario.id_usr = maquina.id_prop where maquina.disponible = 0 and usuario.id_usr = ?1", nativeQuery = true)
   List<Integer> maquinasRentadasPorUsuario(int id_usr);

   @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE Maquina SET maquina.disponible = 1 where maquina.id_maq = ?1", nativeQuery = true)
    void ponerDisponible(int id_maq);



}
