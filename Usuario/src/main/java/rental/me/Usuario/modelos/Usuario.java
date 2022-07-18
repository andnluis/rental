package rental.me.Usuario.modelos;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @SequenceGenerator(
            name="secuencia_usuarios",
            sequenceName = "secuencia_usuarios",
            allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "secuencia_usuarios")
    int id_usr;
    String n_id;
    String nombre;
    String apellido;
    int telefono;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    Direccion direccion;
    String email;
    String clave;
    Date f_nac;
    LocalDateTime creado;
    boolean propietario;


    public Usuario() {
    }

    public Usuario(String n_id, String nombre, String apellido, int telefono, Direccion direccion, String email, String clave, Date f_nac, LocalDateTime creado,  boolean propietario) {
        this.n_id = n_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.clave = clave;
        this.f_nac = f_nac;
        this.creado = creado;
        this.propietario = propietario;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
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



    public boolean isPropietario() {
        return propietario;
    }

    public void setPropietario(boolean propietario) {
        this.propietario = propietario;
    }
}
