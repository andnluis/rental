package rental.me.Imagenes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.me.Imagenes.model.Foto_recibo;
import rental.me.Imagenes.repository.RepoRecibo;

import java.util.List;

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

    public void validar(int id){

        this.rrcb.varlidarRecibo(id);

        List<Integer> maquinas = this.rrcb.getIdMaquinas(id);

        for (int i = 0; i < maquinas.size(); i++) {
            this.rrcb.cambioEstadoMaquina(maquinas.get(i));
        }
    }
}
