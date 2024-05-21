package movie.configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("movie")
@Configuration
public class MyConfiguration {

	@Bean
	public ViewResolver getView() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/frontend/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public EntityManager getEm() {
		return Persistence.createEntityManagerFactory("dbservmovie").createEntityManager();
	}
}
