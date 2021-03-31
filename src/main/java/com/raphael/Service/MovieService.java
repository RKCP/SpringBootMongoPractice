package com.raphael.Service;

import com.raphael.DatabaseAccessObject.MovieDatabaseAccessObject;
import com.raphael.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieService {

	@Autowired
	private MovieDatabaseAccessObject movieDatabaseAccessObject;

	public Collection<Movie> getMovies() {
		return movieDatabaseAccessObject.getMovies();
	}
}
