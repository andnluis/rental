package rental.me.Imagenes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.Imagenes.model.Fotos_perfil;
import rental.me.Imagenes.repository.RepoPerfil;

@Service
public class PerfilService {

    @Autowired
    RepoPerfil rp;

    public void guardar(String uri, int id_usr){
        Fotos_perfil fperfil = new Fotos_perfil(uri, id_usr);
        this.rp.save(fperfil);
    }

    public String getURI(int id){
        return this.rp.getFile(id);
    }
}
