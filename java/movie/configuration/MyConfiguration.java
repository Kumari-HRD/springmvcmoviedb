package movie.configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("movie")
@Configuration
public class MyConfiguration 
{

	@Bean
	public ViewResolver getView()
	{
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/frontend/");
		resolver.setSuffix(".jsp");
		return resolver;
	}	
	
	@Bean
	public EntityManager getEm()
	{
	  return Persistence.createEntityManagerFactory("mvcmovie").createEntityManager();
	}
	
//	//added today
//	 @Bean
//	    public CommonsMultipartResolver multipartResolver() 
//	   {
//	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//	        multipartResolver.setMaxUploadSize(50000000); // Set maximum file size (in bytes)
//	        return multipartResolver;
//	    }
}
