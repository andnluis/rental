package rental.me.Renta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.Renta.model.Orden;
import rental.me.Renta.model.Renta;
import rental.me.Renta.repositorio.RentaRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RentaServicio {

    @Autowired
    private RentaRepo rentaRepo;

    public void guardarRenta(Renta renta){
        this.rentaRepo.save(renta);
    }


    public Renta encontrarRenta(int id_arr){
        return this.rentaRepo.encontrarRenta(id_arr);
    }

    public Renta encontrarLaRenta(int id){
        return this.rentaRepo.encontrarLaRenta(id);
    }

    public List<Orden> obtenerOrdenesPorUsuario(int id){
        List<Orden> ordenes = null;
        List<Renta> rentas;
        rentas = this.rentaRepo.rentasPorUsuario(id);
        for (int i = 0; i < rentas.size(); i++) {
            for (int j = 0; j < rentas.get(i).getOrdenes().size(); j++) {
                ordenes.add(rentas.get(i).getOrdenes().get(j));
            }
        }
        return ordenes;
    }





}
