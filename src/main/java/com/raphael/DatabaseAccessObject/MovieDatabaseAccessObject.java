package com.raphael.DatabaseAccessObject;

import com.raphael.Entity.Movie;
import com.raphael.Entity.UpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class MovieDatabaseAccessObject { // this is the Repository/DAO Layer of a Spring Web Application. This is where we interact with the DB.
	@Autowired
	private MovieRepository repository; // using MovieRepository interface which extends MongoRepository

	/**
	 * Method that returns all movies in the database
	 * @return all movies in the database
	 */
	public Collection<Movie> getMovies() {
		return repository.findAll();
	}

	/**
	 * method to create a movie, or essentially insert a movie into the database
	 * @param movie the movie object to insert
	 * @return the movie that was inserted
	 */
	public Movie createMovie(Movie movie) {
		return repository.insert(movie); //inserts book into the database
	}

	/**
	 * Method that gets the movie from the database if it exists
	 * @param id of the movie to find
	 * @return the movie that was found
	 */
	public Optional<Movie> getMovieById(int id) {
		return repository.findById(id); // using the Spring repository
	}

	/**
	 * Method that deletes the movie from the database if it exists
	 * @param id of the movie to delete
	 * @return the movie that was deleted
	 */
	public Optional<Movie> deleteMovieById(int id) {
		Optional<Movie> movie = repository.findById(id);
		movie.ifPresent(m -> repository.delete(m));
		// .... why does the above work instead of
		// if (movie.isPresent()) { repository.delete(movie); }
		return movie;
	}

	/**
	 * Method that updates the movie in the database if it exists
	 * @param id of the movie to update
	 * @param movieUpdatePayload the payload details to update in the movie
	 * @return the movie if it has been updated
	 */
	public Optional<Movie> updateMovieById(int id, UpdatePayload movieUpdatePayload) {
		Optional<Movie> movie = repository.findById(id);
		movie.ifPresent(m -> m.setTitle(movieUpdatePayload.getTitle()));
		movie.ifPresent(m -> m.setDirector(movieUpdatePayload.getDirector()));
		movie.ifPresent(m -> m.setYear(movieUpdatePayload.getYear()));
		movie.ifPresent(m -> repository.save(m)); // this will save the movie into the database
		return movie;
	}
}
