package movie.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import movie.dto.Movie;
import movie.service.MovieService;

import java.util.List;

@Repository
//Can also be Component
public class MovieDao 
{
	
	@Autowired
	EntityManager manager;
	
	public void saveMovie(Movie movie)
	{
      manager.getTransaction().begin();
	  manager.persist(movie);
	  manager.getTransaction().commit();
	      
	}
	
	public List<Movie> fetchMovies() 
	{		
		return manager.createQuery("select m from Movie m").getResultList();
		
	}
	
	public List<Movie> fetchMoviesById(int id) 
	{
        return manager.createQuery("select m from Movie m where m.id=?1").setParameter(1, id).getResultList();
    }
	
	 public List<Movie> fetchMoviesByName(String name) 
	 {
	       return manager.createQuery("select m from Movie m where m.name=?1").setParameter(1, name).getResultList();
	  } 
	 
	 public List<Movie>  fetchMoviesByRating(double movie_rating)
	 {
	    return manager.createQuery("select m from Movie m where m.rating=?1").setParameter(1, movie_rating).getResultList();
	 }
	 
	 public List<Movie> fetchMoviesByLanguage(String movie_lang) 
	 {
	    return manager.createQuery("select m from Movie m where m.language=?1").setParameter(1, movie_lang).getResultList();
	 }
	 
	 public List<Movie>  fetchMoviesByGenre(String movie_genre) 
	 {    
	     return manager.createQuery("select m from Movie m where m.genre=?1").setParameter(1, movie_genre).getResultList();
	 }
	 
	 public void deleteMovie(int id)
	 {
		 	manager.getTransaction().begin();
		 	manager.remove(manager.find(Movie.class,id));
		 	manager.getTransaction().commit();
	 }
	
     public Movie findMovie(int id)
     {
    	 return manager.find(Movie.class, id);
    }
     
     public void updateMovie(Movie movie)
     {
    	 manager.getTransaction().begin();
    	 manager.merge(movie);
    	 manager.getTransaction().commit();
    }
     
}
       

