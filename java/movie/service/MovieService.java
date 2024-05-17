package movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.List;
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

	private String printList(ModelMap map, List<Movie> list) {
		if (list.isEmpty()) {
			map.put("failure", "No Movies Found");
			return "home";
		} 
		else 
		{
			map.put("list", list);
			return "fetch";
		}
	}
}

