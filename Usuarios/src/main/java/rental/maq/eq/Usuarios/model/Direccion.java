package rental.maq.eq.Usuarios.model;

import javax.persistence.*;

@Entity
@Table(name="direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_dir;
    private String direccion;
    private int id_ciudad;

    public Direccion() {
    }

    public Direccion(int id_dir, String direccion, int id_ciudad) {
        this.id_dir = id_dir;
        this.direccion = direccion;
        this.id_ciudad = id_ciudad;
    }

    public Direccion(String direccion, int id_ciudad) {
        this.direccion = direccion;
        this.id_ciudad = id_ciudad;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}
