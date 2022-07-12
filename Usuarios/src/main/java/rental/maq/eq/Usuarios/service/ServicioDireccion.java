package rental.maq.eq.Usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.maq.eq.Usuarios.model.Direccion;
import rental.maq.eq.Usuarios.repository.DireccionRepository;

import java.util.List;

@Service
public class ServicioDireccion {

    @Autowired
    DireccionRepository dirrep;

    public void crearDireccion(Direccion direccion){
        this.dirrep.save(direccion);
    }

    public Direccion getDireccion(int id){
        return this.dirrep.findById(id);
    }

    public List<Direccion> getDirecciones(){
        return (List<Direccion>) this.dirrep.findAll();
    }
}
