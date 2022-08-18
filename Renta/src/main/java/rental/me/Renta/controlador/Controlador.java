package rental.me.Renta.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rental.me.Renta.model.Orden;
import rental.me.Renta.model.Renta;
import rental.me.Renta.service.OrdenServicio;
import rental.me.Renta.service.RentaServicio;
import net.bytebuddy.utility.RandomString;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class Controlador {

    @Autowired
    RentaServicio rentaServicio;

    @Autowired
    OrdenServicio ordenServicio;


    @GetMapping(value = "/renta")
    public Renta inicializar(@RequestParam(name = "id_arr")int id){
        Renta renta = this.rentaServicio.encontrarRenta(id);

        if(renta == null){
                Renta nuevaRenta = new Renta(id,RandomString.make(4),false, LocalDateTime.now());
                this.rentaServicio.guardarRenta(nuevaRenta);
                return nuevaRenta;
        } else if (renta.isCancelado() == true) {
                Renta otraRenta = new Renta(id,RandomString.make(4),false, LocalDateTime.now());
                this.rentaServicio.guardarRenta(otraRenta);
                return otraRenta;
        }else{
            return renta;
        }
    }

    @GetMapping("/cart")
    public List<Orden> mostrarCarrito(@RequestParam(value = "id_renta")int id_renta){
            Renta renta = this.rentaServicio.encontrarLaRenta(id_renta);
            return renta.getOrdenes();
    }

    @PostMapping(value = "/cart/add")
    public void agregarOrden(@RequestParam(name = "id_maq")int id_maq ,
                             @RequestParam(name = "horas")int horas,
                             @RequestParam(name = "fecha_inicio")LocalDateTime fecha,
                             @RequestParam(name = "id_renta")int id_renta
        ){

        Renta renta = this.rentaServicio.encontrarLaRenta(id_renta);
        Orden orden = new Orden(id_maq,horas,fecha,renta);
        this.ordenServicio.agregarOrden(orden);
    }

    @DeleteMapping (value = "/cart/quitar")
    public void quitarOrden(@RequestParam(name = "id")int id_orden){
        this.ordenServicio.borrarOrden(id_orden);
    }

    @PutMapping(value = "/cart/put/hora")
    public void actualizarHoras(@RequestParam(name = "id") int id,
                                @RequestParam(name = "horas")int horas){
        this.ordenServicio.actualizarHoras(id,horas);
    }

    @PutMapping(value = "/cart/put/inicio")
    public void actualizarFecha(@RequestParam(name = "id")int id, @RequestParam(name = "inicio")LocalDateTime finicio){
        this.ordenServicio.actuarlizarFecha(id,finicio);
    }

    @GetMapping(value = "/stat/rentadas")
    public List<Orden> statUsuario(@RequestParam(name = "id")int id){
        return this.rentaServicio.obtenerOrdenesPorUsuario(id);
    }

    @GetMapping(value = "/stat/usr/ganancia")
    public float totalganado(@RequestParam(name = "usr")int id){
        return this.rentaServicio.totalganancias(id);
    }

    @GetMapping(value = "/stat/maquina/total")
    public float totalmaquina(@RequestParam(name = "maquina")int id){
        return this.rentaServicio.totaldineroganadomaquina(id);
    }

    @GetMapping(value = "/stat/maquina/veces")
    public int vecesmaquina(@RequestParam(name = "maquina")int id){
        return this.rentaServicio.vecesRentadaMaquina(id);
    }

    @GetMapping(value = "/stat/top")
    public List<Integer> topRentadas(){
        return this.rentaServicio.top3();
    }

    @GetMapping(value = "/stat/usr/top")
    public List<Integer> topRentadasUsuario(@RequestParam(name = "usr")int id){
        return this.rentaServicio.top3Usuario(id);
    }

    @GetMapping(value = "/stat/usr/mes")
    public List<Integer> rentadaspormes(@RequestParam(name = "usr")int id, @RequestParam(name = "mes")int mes){
        return this.rentaServicio.maquinaspormes(id,mes);
    }

    @GetMapping(value = "/stat/maquina/retorno")
    public LocalDateTime fechaRetorno(@RequestParam(name = "maquina")int id){
        return this.rentaServicio.fechaRetornoPorMaquina(id);
    }

    public List<Integer> actualesenRenta(@RequestParam(name = "usr")int id){
        return this.rentaServicio.maquinasenRenta(id);
    }

    public String ponerDisponible(@RequestParam(name = "maquina") int id){
        this.rentaServicio.ponerDisponible(id);
        return "Maquina disponible nuevamente";
    }




    @PostMapping(value = "/cart/checkout")
    public String checkout(@RequestParam(name = "id")int id){
        try{
            this.rentaServicio.mandarCorreo(id);
            return "Porfavor revisa tu correo para ver el código con el que cancelaras tu orden en el banco";
        }catch (Exception e){
            return "Ocurrio un error, prueba más tarde";
        }
    }

    @GetMapping(value = "/orden/list")
    public List<Orden> listarOrdenes(){
        return this.ordenServicio.listar();
    }

    @GetMapping(value = "/orden/get")
    public Optional<Orden> encontrarOrden(@RequestParam(name = "id")int id){
        return this.ordenServicio.encontrarUnaOrden(id);
    }









}
