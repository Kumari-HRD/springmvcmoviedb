package movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import movie.dao.MovieDao;
import movie.dto.Movie;
import movie.service.MovieService;

@Controller
@MultipartConfig	
public class MovieController {
	
	@Autowired
	MovieService service;
	
	
	@GetMapping("/")
	public String loadLogin()
	{
		return "login";
	}
	
	@GetMapping("/home")
	public String loadHome()
	{
		return "home";
	}

	
	@PostMapping("/login")
	public String login(@RequestParam String un,@RequestParam String pwd,ModelMap map)
	{
		return service.login(un, pwd, map);
	}
	
	@GetMapping("/insert-movie")
	public String loadInsertMoviePage()
	{
		return "insert-movie";
	}
	
	@GetMapping("/fetch-movies")
	public String fetchAllMovies(ModelMap map) {
		return service.fetchAllMovies(map);
	}
	
	@GetMapping("/fetch-movies-id")
	public String loadMovieById()
	{
		return "enter-id";
		
	}
	
	@GetMapping("/fetch-movies-name")
	public String loadMovieByName()
	{
		return "enter-name";
		
	}
	
	@GetMapping("/fetch-movies-rating")
	public String loadMovieByRating()
	{
		return "enter-rating";
		
	}
	
	@GetMapping("/fetch-movies-language")
	public String loadMovieByLanguage()
	{
		return "enter-language";
		
	}
	
	@GetMapping("/fetch-movies-genre")
	public String loadMovieByGenre()
	{
		return "enter-genre";
		
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		return "login";
		
	}
	
	@PostMapping("/insert-movie")
	//public String saveMovie(@ModelAttribute Movie movie, ModelMap map)
	public String saveMovie(Movie movie, ModelMap map)
	{
		return service.saveMovie(movie,map);
	}
	
//	@PostMapping("/insert-movie")
//	//public String saveMovie(@ModelAttribute Movie movie, ModelMap map)
//	public String saveMovie(@RequestParam String name,
//            @RequestParam String language,
//            @RequestParam double rating,
//            @RequestParam String genre,
//            @RequestParam MultipartFile picture,
//             ModelMap map)
//	{
//		return service.saveMovie1(name,language, rating, genre, picture,map);
//	}
//	
	@PostMapping("/fetch-movies-id")
	public String fetchMovieById(@RequestParam int id,ModelMap map) {
		return service.fetchMovieById(id,map);
	}

	@PostMapping("/fetch-movies-name")
	public String fetchMovieByName(@RequestParam String name,ModelMap map) {
		return service.fetchMovieByName(name,map);
	}

	@PostMapping("/fetch-movies-rating")
	public String fetchMovieByRating(@RequestParam double rating,ModelMap map) {
		return service.fetchMovieByRating(rating,map);
	}

	@PostMapping("/fetch-movies-language")
	public String fetchMovieByLanguage(@RequestParam String language,ModelMap map) {
		return service.fetchMovieByLanguage(language,map);
	}

	@PostMapping("/fetch-movies-genre")
	public String fetchMovieByGenre(@RequestParam String genre,ModelMap map) {
		return service.fetchMovieByGenre(genre,map);
	}
	
	@GetMapping("/delete-movie")
	public String delete(@RequestParam int id, ModelMap map) {
		return service.delete(id, map);
	}
	
	@GetMapping("/edit-movie")
	public String editMovie(@RequestParam int id, ModelMap map) {
		return "Yet to construct";
		//return service.editMovie(id, map);
	}	
	
	@PostMapping("/edit-movie")
	@ResponseBody
	public String updateMovie(Movie movie, ModelMap map) 
	{
		return movie.toString();
	}
	
}
	