package rental.me.Renta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orden {

    @Id
    @SequenceGenerator(
            name = "secuencia_orden",
            sequenceName = "secuencia_orden",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "secuencia_orden")
    private int id_orden;

    private int id_maq;

    private int horas_rentadas;

    private LocalDateTime fecha_inicio;

    private LocalDateTime fecha_final;

    @ManyToOne
    @JoinColumn(name = "id_renta")
    @JsonBackReference
    private Renta renta;

    public Orden() {
    }

    public Orden( int id_maq, int horas_rentadas, LocalDateTime fecha_inicio, Renta renta) {
        this.id_maq = id_maq;
        this.horas_rentadas = horas_rentadas;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_inicio.plusHours(horas_rentadas);
        this.renta = renta;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_maq() {
        return id_maq;
    }

    public void setId_maq(int id_maq) {
        this.id_maq = id_maq;
    }

    public int getHoras_rentadas() {
        return horas_rentadas;
    }

    public void setHoras_rentadas(int horas_rentadas) {
        this.horas_rentadas = horas_rentadas;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(LocalDateTime fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
    }
}
