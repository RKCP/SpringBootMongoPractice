package com.raphael.DatabaseAccessObject;

import com.raphael.Entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, Integer> {
	// if wanted to add methods like find by title, find by year, then we would need to define it in here.
}
