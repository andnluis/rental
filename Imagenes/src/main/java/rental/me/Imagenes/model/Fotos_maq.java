package rental.me.Imagenes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fotos_maq {

    @Id
    private String uri;
    private int id_maq;

    public Fotos_maq() {
    }

    public Fotos_maq(String uri, int id_maq) {
        this.uri = uri;
        this.id_maq = id_maq;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getId_maq() {
        return id_maq;
    }

    public void setId_maq(int id_maq) {
        this.id_maq = id_maq;
    }
}
