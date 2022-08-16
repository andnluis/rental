package rental.me.Renta.model;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Renta {

    @Id
    @SequenceGenerator(
            name = "secuencia_renta",
            sequenceName = "secuencia_renta",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_renta")
    private int id_renta;

    private int id_arr;

    private String codigo_reserva;

    private boolean cancelado;

    private LocalDateTime creado;
    @OneToMany(mappedBy = "renta", fetch = FetchType.EAGER)
    public List<Orden> ordenes;

    public Renta() {
    }

    public Renta( int id_arr, String codigo_reserva, boolean cancelado, LocalDateTime creado) {
        this.id_arr = id_arr;
        this.codigo_reserva = codigo_reserva;
        this.cancelado = cancelado;
        this.creado = creado;
    }

    public int getId_renta() {
        return id_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public int getId_arr() {
        return id_arr;
    }

    public void setId_arr(int id_arr) {
        this.id_arr = id_arr;
    }



    public String getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(String codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }
}
