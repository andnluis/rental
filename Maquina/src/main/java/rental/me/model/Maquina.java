package rental.me.model;


import javax.persistence.*;

@Entity
public class Maquina {

    @Id
    @SequenceGenerator(name = "secuencia_maquina", sequenceName = "secuencia_maquina", initialValue = 301)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_maquina")
    int id_maq; //Id de la maquina

    int id_man; //Id del manufacturador de la maquina, osea CAT, John Deere, Volvo
    int id_prop;
    String n_serie;
    boolean disponible;
    int id_tipo;
    float pph; //precio por hora
    int ubicacion;
    String modelo_motor;
    float potencia;
    float peso;


    public Maquina() {
    }

    public Maquina( int id_man, int id_prop, String n_serie, boolean disponible, int id_tipo, float pph, int ubicacion, String modelo_motor, float potencia, float peso) {
        this.id_man = id_man;
        this.id_prop = id_prop;
        this.n_serie = n_serie;
        this.disponible = disponible;
        this.id_tipo = id_tipo;
        this.pph = pph;
        this.ubicacion = ubicacion;
        this.modelo_motor = modelo_motor;
        this.potencia = potencia;
        this.peso = peso;
    }

    public int getId_maq() {
        return id_maq;
    }

    public void setId_maq(int id_maq) {
        this.id_maq = id_maq;
    }

    public int getId_man() {
        return id_man;
    }

    public void setId_man(int id_man) {
        this.id_man = id_man;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    public String getN_serie() {
        return n_serie;
    }

    public void setN_serie(String n_serie) {
        this.n_serie = n_serie;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public float getPph() {
        return pph;
    }

    public void setPph(float pph) {
        this.pph = pph;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicación) {
        this.ubicacion = ubicación;
    }

    public String getModelo_motor() {
        return modelo_motor;
    }

    public void setModelo_motor(String modelo_motor) {
        this.modelo_motor = modelo_motor;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}
