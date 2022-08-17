package rental.me.Imagenes.controller;

import rental.me.Imagenes.payload.UploadFileResponse;
import rental.me.Imagenes.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rental.me.Imagenes.service.MaquinaService;
import rental.me.Imagenes.service.PerfilService;
import rental.me.Imagenes.service.ReciboService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    MaquinaService ms;

    @Autowired
    PerfilService ps;

    @Autowired
    ReciboService rs;

    @PostMapping("/maquina/up")
    public UploadFileResponse subirMaquina(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        String galbdd = fileName;
        this.ms.guardar(galbdd,id);
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/usuario/up")
    public UploadFileResponse subirUsuario(@RequestParam("file") MultipartFile file, @RequestParam("id")int id) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        this.ps.guardar(fileDownloadUri,id);
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/renta/up")
    public UploadFileResponse subirRenta(@RequestParam("file") MultipartFile file, @RequestParam("id")int id) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        this.rs.guardar(fileDownloadUri,id);
        this.rs.validar(id);
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping(value = "/maquina/get")
    public String obtenerMaquina(@RequestParam int id) {

        String foto = this.ms.obtenerURI(id);

        if(foto != null){
            return foto;
        }else{
            return "http://localhost:8070/downloadFile/NOMAQUINA.png";
        }
    }
    @GetMapping(value = "/usuario/get")
    public String obtenerPerfiles(@RequestParam int id) {
        String foto = this.ps.getURI(id);
        if(foto != null) {
            return this.ps.getURI(id);
        }else {
            return "http://localhost:8070/downloadFile/NOPERFIL.png";
        }
    }

    @GetMapping(value = "/renta/get")
    public String obtenerRecibo(@RequestParam int id) {
        String foto = this.rs.getURI(id);
        if(foto != null){
            return foto;
        }else {
            return "http://localhost:8070/downloadFile/NORECIBO.png";
        }
    }







}
