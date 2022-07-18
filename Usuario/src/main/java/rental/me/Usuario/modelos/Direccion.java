package rental.me.Usuario.modelos;



import javax.persistence.*;

@Entity
@Table(name = "Direccion")
public class Direccion {

    @Id
    @SequenceGenerator(
                    name = "secuencia_direccion",
                    sequenceName = "secuencia_direccion",
                    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "secuencia_direccion")
    int id_dir;
    String direccion;
    int id_ciudad;

    public Direccion() {
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
