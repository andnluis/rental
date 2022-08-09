package rental.me.Imagenes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.Imagenes.model.Foto_recibo;
import rental.me.Imagenes.repository.RepoRecibo;

@Service
public class ReciboService {

    @Autowired
    RepoRecibo rrcb;

    public void guardar(String uri, int id_renta){
        Foto_recibo frec = new Foto_recibo(uri, id_renta);
        this.rrcb.save(frec);
    }

    public String getURI(int id){
        return this.rrcb.getFile(id);
    }
}
