package buffetAplicacion.config;

import buffetAplicacion.filter.JWTAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // Indica que es una clase de configuración
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuración global de CORS para toda la aplicación
        registry.addMapping("/**")  // Permite todas las rutas de la aplicación
                .allowedOrigins("http://localhost:4200")  // Permite solicitudes solo desde localhost:4200
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos HTTP permitidos
                .allowedHeaders("*")  // Permite todos los encabezados
                .allowCredentials(true);  // Permite el uso de credenciales (como cookies o tokens)
    }

   @Bean
    public FilterRegistrationBean<JWTAuthenticationFilter> jwtAuthenticationFilter() {
        FilterRegistrationBean<JWTAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JWTAuthenticationFilter()); // Instancia del filtro
        registrationBean.addUrlPatterns("/*"); // Aplica el filtro a todas las URLs
        registrationBean.setOrder(1); // Define el orden del filtro
        return registrationBean;
    }
}