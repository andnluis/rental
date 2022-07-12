package rental.maq.eq.Usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.maq.eq.Usuarios.model.Arrendatario;
import rental.maq.eq.Usuarios.repository.ArrendatarioRepository;

import java.util.List;

@Service
public class ServicioArrendatario {

    @Autowired
    ArrendatarioRepository arrep;

    public void crearArr(Arrendatario arrendatario){
        this.arrep.save(arrendatario);
    }

    public Arrendatario obtenerArrendatario(int id){
        return this.arrep.findById(id);
    }

    public List<Arrendatario> getArrendatarios(){
        return (List<Arrendatario>) this.arrep.findAll();
    }
}
