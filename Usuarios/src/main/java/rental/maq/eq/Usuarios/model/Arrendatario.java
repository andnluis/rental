package rental.maq.eq.Usuarios.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name="arrendatario")
public class Arrendatario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_arr;

    private String n_id;
    private String nombre;
    private String apellido;
    private int telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_dir", referencedColumnName = "id_dir")
    private Direccion direccion;

    private String email;
    private String clave;

    @Column(name = "creado")
    private LocalDateTime creado;

    @Lob
    private byte[] pfp;

    public Arrendatario(String n_id, String nombre, String apellido, int telefono, Direccion direccion, String email, String clave, LocalDateTime creado, byte[] pfp) {
        this.n_id = n_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.clave = clave;
        this.creado = creado;
        this.pfp = pfp;
    }

    public Arrendatario() {
    }

    public int getId_arr() {
        return id_arr;
    }

    public void setId_arr(int id_arr) {
        this.id_arr = id_arr;
    }

    public String getN_id() {
        return n_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public byte[] getPfp() {
        return pfp;
    }

    public void setPfp(byte[] pfp) {
        this.pfp = pfp;
    }

    @Override
    public String toString() {
        return "Arrendatario{" +
                "id_arr=" + id_arr +
                ", n_id='" + n_id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", direccion=" + direccion +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", creado=" + creado +
                ", pfp=" + Arrays.toString(pfp) +
                '}';
    }
}
