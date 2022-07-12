package rental.maq.eq.Usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.maq.eq.Usuarios.model.Propietario;
import rental.maq.eq.Usuarios.repository.PropietarioRepository;

import java.util.List;

@Service
public class ServicioPropietario {

    @Autowired
    PropietarioRepository proprep;


    public void crearPropietario(Propietario propietario){
        this.proprep.save(propietario);
    }

    public Propietario Propietario(int id){
        return this.proprep.findById(id);
    }

    public List<Propietario> obtenerPropietarios(){
        return (List<Propietario>) this.proprep.findAll();
    }
}
