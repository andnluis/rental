package rental.me.Imagenes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.Imagenes.model.Fotos_maq;
import rental.me.Imagenes.repository.RepoMaquina;

@Service
public class MaquinaService {

    @Autowired
    RepoMaquina repomaquina;

    public void guardar(String uri, int id_maq){
        Fotos_maq fm = new Fotos_maq(uri, id_maq);
        this.repomaquina.save(fm);
    }
}
