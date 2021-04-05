package com.raphael.Service;

import com.raphael.DatabaseAccessObject.MovieDatabaseAccessObject;
import com.raphael.Entity.Movie;
import com.raphael.Entity.UpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MovieService { // this is the Service Layer of a Spring Web Application

	@Autowired
	private MovieDatabaseAccessObject movieDatabaseAccessObject;

	/**
	 * Method that accesses the repository layer and tells it what movie to get
	 * @return the movie that was retrieved
	 */
	public Collection<Movie> getMovies() {
		return movieDatabaseAccessObject.getMovies();
	}

	/**
	 * Method that accesses the repository layer and tells it what to insert into the database
	 * @param movie the movie to insert
	 * @return the movie that was inserted
	 */
	public Movie createMovie(Movie movie) {
		return movieDatabaseAccessObject.createMovie(movie);
		// can carry out business logic in here if required
	}

	/**
	 * Method that accesses the repository layer and tells it which movie to retrieve
	 * @param id of the movie to get
	 * @return the movie that was retrieved
	 */
	public Optional<Movie> getMovieById(int id) {
		return movieDatabaseAccessObject.getMovieById(id);
	}

	/**
	 * Method that accesses the repository layer and tells it which movie to delete
	 * repository layer is the layer that interacts with the mongoDB database
	 * @param id of the movie to delete
	 * @return the movie that was deleted
	 */
	public Optional<Movie> deleteMovieById(int id) {
		return movieDatabaseAccessObject.deleteMovieById(id);
	}

	/**
	 * Method that accesses the repository layer and tells it which movie to update
	 * @param id of the movie to update
	 * @param movieUpdatePayload payload to update movie with
	 * @return the movie that was updated
	 */
	public Optional<Movie> updateMovieById(int id, UpdatePayload movieUpdatePayload) {
		return movieDatabaseAccessObject.updateMovieById(id, movieUpdatePayload);
	}
}
