package rental.me.Renta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.Renta.model.Orden;
import rental.me.Renta.repositorio.OrdenRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenServicio {

    @Autowired
    private OrdenRepo ordenRepo;

    public void agregarOrden(Orden orden){
        ordenRepo.save(orden);
    }


    public void actualizarHoras(int id, int horas){
        this.ordenRepo.actualizarHoras(id,horas);
        LocalDateTime fechafinal = this.ordenRepo.obtenerOrden(id).getFecha_inicio().plusHours(horas);
        this.ordenRepo.actualizarFechaFinal(id, fechafinal);
    }

    public void actuarlizarFecha(int id, LocalDateTime inicio){
        this.ordenRepo.actualizarFechaInicio(id,inicio);
        Orden orden = this.ordenRepo.obtenerOrden(id);
        LocalDateTime fechafinal = inicio.plusHours(orden.getHoras_rentadas());
        this.ordenRepo.actualizarFechaFinal(id, fechafinal);
    }

    public List<Orden> listar(){
        return (List<Orden>) this.ordenRepo.findAll();
    }

    public Optional<Orden> encontrarUnaOrden(int id){
        return this.ordenRepo.findById(id);
    }

    public void borrarOrden(int id){
        this.ordenRepo.deleteById(id);
    }



}
