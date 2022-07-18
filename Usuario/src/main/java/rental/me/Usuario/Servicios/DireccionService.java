package rental.me.Usuario.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.Usuario.Repositorios.DireccionRepositorio;
import rental.me.Usuario.modelos.Direccion;

@Service
public class DireccionService {

    @Autowired
    DireccionRepositorio dirrep;

    public void crearDireccion(Direccion direccion){
        this.dirrep.save(direccion);
    }
}
