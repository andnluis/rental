package rental.maq.eq.Usuarios.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_prop;
    private String n_id;
    private String nombre;
    private String apellido;
    private int telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    private Direccion direccion;

    private String email;
    private String clave;

    @Column(name="f_nac")
    private Date f_nac;

    @Column(name="creado")
    private LocalDateTime creado;

    @Lob
    private byte[] pfp;

    public Propietario( String n_id, String nombre, String apellido, int telefono, Direccion direccion, String email, String clave, Date f_nac, LocalDateTime creado, byte[] foto) {
        this.n_id = n_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.clave = clave;
        this.f_nac = f_nac;
        this.creado = creado;
        this.pfp = foto;
    }


    public Propietario() {

    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
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

    public Date getF_nac() {
        return f_nac;
    }

    public void setF_nac(Date f_nac) {
        this.f_nac = f_nac;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public byte[] getpfp() {
        return pfp;
    }

    public void setpfp(byte[] foto) {
        this.pfp = foto;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id_prop=" + id_prop +
                ", n_id='" + n_id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", direccion=" + direccion +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", f_nac=" + f_nac +
                ", creado=" + creado +
                ", pfp=" + Arrays.toString(pfp) +
                '}';
    }
}
