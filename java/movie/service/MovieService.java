package movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.MovieDao;
import movie.dto.Movie;

@Component
public class MovieService 

{
	@Autowired
	MovieDao movieDao;
	
	public String login( String un, String pwd,ModelMap map)
	{
		if(un.equals("admin") && pwd.equals("admin")) 
		{
			map.put("success", "Login Success");
			return "home";
		}
		else 
		{
			map.put("failure", "Invalid Credentials");
			return "login";
		
		}
	}
	
	public String saveMovie(Movie movie, ModelMap map)
	{	
		movieDao.saveMovie(movie);
		map.put("success", "Movie Added Successfully");
		return "home";
	}
	
//	public String saveMovie1(String name,
//            String language,
//            double rating,
//            String genre,
//            MultipartFile picture,
//            ModelMap map)
//	{	
//		try
//		{
//			Movie movie = new Movie();
//	        movie.setName(name);
//	        movie.setLanguage(language);
//	        movie.setRating(rating);
//	        movie.setGenre(genre);
//	        
//	        if (!picture.isEmpty()) 
//	        {
//	            byte[] imageBytes = picture.getBytes();
//	            movie.setPicture(imageBytes);
//	        }
//	        
//			movieDao.saveMovie(movie);
//			map.put("success", "Movie Added Successfully");
//			return "home";
//		}
//		catch(Exception e)
//		{
//	        map.put("failure", "Error saving movie: " + e.getMessage());
//	        return "insert-movie";
//	    }
//	}

	public String fetchAllMovies(ModelMap map) {
		List<Movie> list = movieDao.fetchMovies();
		return printList(map, list);
	}

	public String fetchMovieById(int id, ModelMap map) {
		List<Movie> list = movieDao.fetchMoviesById(id);
		return printList(map, list);
	}

	public String fetchMovieByName(String name, ModelMap map) {
		List<Movie> list = movieDao.fetchMoviesByName(name);
		return printList(map, list);
	}

	public String fetchMovieByRating(double rating, ModelMap map) {
		List<Movie> list = movieDao.fetchMoviesByRating(rating);
		return printList(map, list);
	}

	public String fetchMovieByLanguage(String language, ModelMap map) {
		List<Movie> list = movieDao.fetchMoviesByLanguage(language);
		return printList(map, list);
	}

	public String fetchMovieByGenre(String genre, ModelMap map) {
		List<Movie> list = movieDao.fetchMoviesByGenre(genre);
		return printList(map, list);
	}

	private String printList(ModelMap map, List<Movie> list) 
	{
		if (list.isEmpty()) 
		{
			map.put("failure", "No Movies Found");
			return "home";
		} 
		else 
		{
			map.put("list", list);
			return "fetch";
		}
	}

	public String delete(int id, ModelMap map)
	{
		movieDao.deleteMovie(id);
		map.put("success", "Movie Removed Success");
		return "home";
	}
	
	public String editMovie(int id, ModelMap map) 
	{
		Movie movie=movieDao.findMovie(id);
	 	map.put("movie", movie);
	 	return "edit-movie";
	}
	
	
}

