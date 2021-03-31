package com.raphael.DatabaseAccessObject;

import com.raphael.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MovieDatabaseAccessObject {
	@Autowired
	private MovieRepository repository;
	public Collection<Movie> getMovies() {
		return repository.findAll();
	}

	public Movie createMovie(Movie movie) {
		return repository.insert(movie); //inserts book into the database
	}
}
