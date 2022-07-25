package rental.me.Imagenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Controlador {

        @Autowired
        ImagenesServicio imgser;

        public Controlador(ImagenesServicio imagenesServicio){
            this.imgser = imagenesServicio;
        }

        @PostMapping(value = "/subir")
        public ResponseEntity<RespuestaSubida> subirArchivo(@RequestParam(name = "archivo", required = false)MultipartFile archivo){
                String nombreArchivo = imgser.almacenar(archivo);
                RespuestaSubida subirRespuesta = new RespuestaSubida(nombreArchivo);
                return ResponseEntity.ok().body(subirRespuesta);
        }
}
