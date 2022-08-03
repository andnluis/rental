package rental.me.Usuario.Seguridad;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecutiryConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .httpBasic().and()
               .authorizeRequests()
               .antMatchers(HttpMethod.GET,"/usr/**").permitAll()
               .antMatchers(HttpMethod.PUT,"/usr/**").permitAll()
               .antMatchers(HttpMethod.POST,"/usr/**").permitAll()
               .and().csrf().disable();
    }
}
