package rental.me.Renta.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rental.me.Renta.model.Orden;
import rental.me.Renta.model.Renta;
import rental.me.Renta.repositorio.RentaRepo;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentaServicio {

    @Autowired
    private RentaRepo rentaRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    public void mandarCorreo(int id_renta) {
        Renta renta = this.encontrarLaRenta(id_renta);
        String email = this.rentaRepo.correodeArrendatario(renta.getId_arr());
        String arrendatario = this.rentaRepo.nombreArrendatario(renta.getId_arr());
        String cuerpo = "Estimado(a) Señor(a) " + arrendatario + '\n';
        cuerpo += "\nSu pedido de maquinarias ha sido procesado, porfavor proceda a pagar en el banco con el siguiente codigo: \n\n";
        cuerpo += renta.getCodigo_reserva() + "\n\n";
        DecimalFormat numberFormato = new DecimalFormat("#,###.00");
        cuerpo += "Debera de pagar la cantidad de: L. " + numberFormato.format(this.rentaRepo.getTotal(id_renta) * 1.15);
        cuerpo += "\nPorfavor realiza tu pago lo más pronto posible y sube el comprobante a la pagina para corrobar el pago.\n\n";
        SimpleMailMessage correo = new SimpleMailMessage();
        correo.setFrom("rentalmaquinariayequipo@gmail.com");
        correo.setTo(email);
        correo.setText(cuerpo);
        correo.setSubject("Cancele en el banco su pedido de renta.");
        try {
            javaMailSender.send(correo);
            System.out.println("Correo enviado exitosamente a " + email);
        } catch (Exception e) {
            System.out.println("Error: correo no enviado a " + email);
        }
    }

    public String nombreMaquina(int id_maq){
        return this.rentaRepo.nombreMaquina(id_maq);
    }

    public void guardarRenta(Renta renta) {
        this.rentaRepo.save(renta);
    }


    public Renta encontrarRenta(int id_arr) {
        return this.rentaRepo.encontrarRenta(id_arr);
    }

    public Renta encontrarLaRenta(int id) {
        return this.rentaRepo.encontrarLaRenta(id);
    }

    public List<Orden> obtenerOrdenesPorUsuario(int id) {
        List<Renta> rentas = this.rentaRepo.rentasPorUsuario(id);
        List<Orden> ordenes = rentas.get(0).getOrdenes();
        for (int i = 1; i < rentas.size(); i++) {
            for (int j = 0; j < rentas.get(i).getOrdenes().size(); j++) {
                ordenes.add(rentas.get(i).getOrdenes().get(j));
            }
        }
        return ordenes;
    }

    public float obtenerTotal(int id_renta) {
        return this.rentaRepo.getTotal(id_renta);
    }

    public float totalganancias(int id_usr) {
        return this.rentaRepo.totaldineroUsuario(id_usr);
    }

    public float totaldineroganadomaquina(int id_maq){
        return this.rentaRepo.totaldineroMaquina(id_maq);
}

    public int vecesRentadaMaquina(int id_maq){
        return this.rentaRepo.vecesMaquinaRentada(id_maq);
    }

    public List<Integer> top3(){
        return this.rentaRepo.top3maquinas();
    }

    public List<Integer> top3Usuario(int id_usr){
        return this.rentaRepo.top3maquinasporusuario(id_usr);
    }

    public List<Integer> maquinaspormes(int id_usr, int mes){
        return  this.rentaRepo.maquinapormes(id_usr, mes);
    }

    public LocalDateTime fechaRetornoPorMaquina(int id_maq){
        return this.rentaRepo.fechadeRetorno(id_maq);
    }

    public List<Integer> maquinasenRenta(int id_usr){
        return this.rentaRepo.maquinasRentadasPorUsuario(id_usr);
    }

    public void ponerDisponible(int id_maq){
        this.rentaRepo.ponerDisponible(id_maq);
    }



}
