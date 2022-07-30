package rental.me.Imagenes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Foto_recibo {

    @Id
    private String uri;
    private int id_renta;

    public Foto_recibo(String uri, int id_renta) {
        this.uri = uri;
        this.id_renta = id_renta;
    }

    public Foto_recibo() {
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getId_renta() {
        return id_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }
}
