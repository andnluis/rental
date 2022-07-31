package rental.me.Renta.Modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Renta {
    @Id
   // @SequenceGenerators( name = "secuencia_renta",
                        //SequenceName= "secuencia_renta",
                       // AllocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_renta")
    //ID maquina
    //Id arrendatario
    private int horas_rentadas;
    private Date fecha_inicio;
    private Date fecha_final;
    private String codigo_reserva;
    public Renta(){

    }
    public Renta(int horas_rentadas, Date fecha_inicio, Date fecha_final, String codigo_reserva) {
        this.horas_rentadas = horas_rentadas;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.codigo_reserva = codigo_reserva;
    }

    public int getHoras_rentadas() {
        return horas_rentadas;
    }

    public void setHoras_rentadas(int horas_rentadas) {
        this.horas_rentadas = horas_rentadas;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(String codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }
}






