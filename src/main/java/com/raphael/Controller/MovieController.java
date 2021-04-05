package com.raphael.Controller;

import com.raphael.Entity.Movie;
import com.raphael.Entity.UpdatePayload;
import com.raphael.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/**
 * This is the Web Layer of the spring application. Contains the GET/POST methods the user interacts with
 */
@RestController
@RequestMapping("movies") // what endpoint
public class MovieController {

	/**
	 * Creating a movieService object and connecting it up through Spring rather than normal instantiation
	 */
	@Autowired // using the spring framework, Autowired means we don't have to instantiate, its auto resolved
	private MovieService movieService;

	/**
	 * Connects to GET request and gets movies
	 * @return the movies in the mongoDB database
	 */
	@GetMapping // lets spring know that this is for GET requests
	public Collection<Movie> getMovies() {
		return movieService.getMovies();
	}

	/**
	 * Connects to POST request and posts new movie to database
	 * @param movie to post into database
	 * @return movie that is posted into the database
	 */
	@PostMapping // lets spring know that this is for POST requests to our /movies route
	public Movie postMovie(@RequestBody Movie movie) { //returns a movie back whenever someone POSTs a movie
		return movieService.createMovie(movie);
	}

	/**
	 * Connects to GET request and gets the movie with the given ID
	 * @param id of the movie to get
	 * @return the movie that matches the given ID.
	 */
	@GetMapping(value="/{id}") // add /id to the end of the GET Request
	public Optional<Movie> getMovieById(@PathVariable("id") int id) { // Uses Optional because the movie may or may not exist.
		return movieService.getMovieById(id);
	}

	/**
	 * Connects to DELETE request and deletes the movie with the given ID
	 * @param id of the movie to be deleted
	 * @return the movie that has been deleted
	 */
	@DeleteMapping(value="/{id}")
	public Optional<Movie> deleteMovieById(@PathVariable("id") int id) {
		return movieService.deleteMovieById(id);
	}

	/**
	 * Connects to PUT request and updates the movie with the given ID and payload
	 * @param id of the movie to be updated
	 * @param movieUpdatePayload the payload that will contain the update information
	 * @return the movie that was been updated
	 */
	@PutMapping(value="/{id}")
	public Optional<Movie> updateMovieById(@PathVariable("id") int id, @RequestBody UpdatePayload movieUpdatePayload) {
		return movieService.updateMovieById(id, movieUpdatePayload);
	}
}
