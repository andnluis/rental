package rental.me.Imagenes;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class ConfiguracionRecursosWeb implements WebMvcConfigurer {
    final Environment environment;

    public ConfiguracionRecursosWeb(Environment env){
        this.environment = env;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registro){
        String locacion = environment.getProperty("app.file.storage.mapping");
        registro.addResourceHandler("/subidas/**").addResourceLocations(locacion);
    }
}
