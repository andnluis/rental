package rental.me.Imagenes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fotos_perfil {

    @Id
    private String uri;
    private int id_usr;

    public Fotos_perfil() {
    }

    public Fotos_perfil(String uri, int id_usr) {
        this.uri = uri;
        this.id_usr = id_usr;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }
}
