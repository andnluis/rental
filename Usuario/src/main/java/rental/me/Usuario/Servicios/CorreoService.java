package rental.me.Usuario.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rental.me.Usuario.modelos.Usuario;


@Service
public class CorreoService {

    @Autowired
    private JavaMailSender mailSender;

    public void mandarCorreo(Usuario usr, String asunto, String cuerpo){
        SimpleMailMessage correo = new SimpleMailMessage();
        correo.setFrom("rental.mye@gmail.com");
        correo.setTo(usr.getEmail());
        correo.setText(cuerpo);
        correo.setSubject(asunto);
        try {
            mailSender.send(correo);
            System.out.println("Correo enviado exitosamente a "+usr.getEmail());
        }catch (Exception e){
            System.out.println("Error: correo no enviado a "+usr.getEmail());
        }
    }
}

