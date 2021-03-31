package com.raphael.Controller;

import com.raphael.Entity.Movie;
import com.raphael.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("movies") // what endpoint
public class MovieController {

	@Autowired // using the spring framework, Autowired means we don't have to instantiate, its auto resolved
	private MovieService movieService;

	@GetMapping // lets spring know that this is for GET requests
	public Collection<Movie> getMovies() {
		return movieService.getMovies();
	}

	@PostMapping // lets spring know that this is for POST requests to our /movies route
	public Movie postMovie(@RequestBody Movie movie) { //returns a movie back whenever someone POSTs a movie
		return movieService.createMovie(movie);
	}
}
