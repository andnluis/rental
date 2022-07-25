package rental.me.Imagenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class ImagenesServicio {

    private final Path locacion;

    @Autowired
    public ImagenesServicio(Environment env){
        this.locacion = Paths.get(env.getProperty("app.file.upload-dir", "./subidas/archivos"))
                .toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.locacion);
        }catch (Exception e){
            throw new RuntimeException("No se pudo crear el directorio", e);
        }
    }

    private String obtenerExtension(String nombreArchivo){
        if(nombreArchivo == null){
            return null;
        }
        String[] partesArchivo = nombreArchivo.split("\\.");
        return partesArchivo[partesArchivo.length - 1];
    }

    public String almacenar(MultipartFile archivo){
        String nombreArchivo = new Date().getTime() + "-arch." + obtenerExtension(archivo.getOriginalFilename());

        try{
            if(nombreArchivo.contains("..")){
                throw new RuntimeException(
                  "Los nombres de archivos contienen una secuencia no valida "+nombreArchivo
                );
            }
            Path locacionFinal = this.locacion.resolve(nombreArchivo);
            Files.copy(archivo.getInputStream(), locacionFinal, StandardCopyOption.REPLACE_EXISTING);
            return nombreArchivo;
        }catch (IOException e){
            throw new RuntimeException("No se pudo almacenar el archivo "+nombreArchivo+" porfavor intente de nuevo.",e);
        }

    }


}
