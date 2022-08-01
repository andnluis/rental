package rental.me.Usuario.modelos;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {

    public static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "secuencia_usuarios",
            sequenceName = "secuencia_usuarios",
            allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "secuencia_usuarios")
    int id_usr;
    String nombre;
    String apellido;
    int telefono;
    String email;
    String clave;
    LocalDateTime creado;
    boolean propietario;

    boolean habilitado;

    String verificacion;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, int telefono, String email, String clave, LocalDateTime creado, boolean propietario, boolean habilitado, String verificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        this.creado = creado;
        this.propietario = propietario;
        this.habilitado = habilitado;
        this.verificacion = verificacion;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
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

    public boolean isPropietario() {
        return propietario;
    }

    public void setPropietario(boolean propietario) {
        this.propietario = propietario;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(String verificación) {
        this.verificacion = verificación;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}