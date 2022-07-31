package rental.me.Renta.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rental.me.Renta.Modelo.Renta;
import rental.me.Renta.Servicio.RentaServicio;

import java.util.Date;

@RestController
public class Controlador {
    @Autowired
    RentaServicio ser_rent;
    @RequestMapping(value = "/renta/add", method = RequestMethod.POST)
    public Renta crearRenta(@RequestParam(name = "hora_rent") int horas_rentadas,
                            @RequestParam (name = "fech_in") Date fecha_inicio,
                            @RequestParam (name = "fech_fin") Date fecha_final,
                            @RequestParam (name = "codig_rese") String codigo_reserva){
        Renta renta = new Renta(horas_rentadas,fecha_inicio,fecha_final,codigo_reserva);
        this.ser_rent.crear_Renta(renta);
        return renta;
    }

}
