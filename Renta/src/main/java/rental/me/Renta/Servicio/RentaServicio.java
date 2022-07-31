package rental.me.Renta.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import rental.me.Renta.Modelo.Renta;
import rental.me.Renta.Repositorio.RepositorioRenta;
@Service
public class RentaServicio {
    @Autowired
    RepositorioRenta repositorioRenta;

    // crear renta
    public void crear_Renta(Renta renta) {
        this.repositorioRenta.save(renta);// falta de crear en repositoriorenta
    }

}