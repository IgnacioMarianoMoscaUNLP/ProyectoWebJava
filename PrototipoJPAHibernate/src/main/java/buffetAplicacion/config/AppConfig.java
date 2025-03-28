package buffetAplicacion.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import buffetAplicacion.*;

@Configuration
@EnableWebMvc
@ComponentScan (basePackages = {"buffetAplicacion",
	"buffetAplicacion.config",
	"buffetAplicacion.controllers",
	"buffetAplicacion.Modelo",
	"buffetAplicacion.exceptions",
	"buffetAplicacion.services",
	"buffetAplicacion.repository"
}
		)
public class AppConfig implements WebMvcConfigurer {
	@Override
	public void extendMessageConverters (List<HttpMessageConverter<?>> converters) { 
				converters.add(new MappingJackson2HttpMessageConverter());
	}
}