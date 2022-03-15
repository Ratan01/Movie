package com.cg.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Movie;

@Repository("movieRepo")
public interface MovieRepository extends JpaRepository<Movie, String> {
	Optional<Movie> findByMovieName(Movie m);
	void deleteByMovieName(Movie m);
	//Optional<Movie> findByCategory(String movie);
	Optional<Movie> findByGenre(String movie);
}



/////////// http://localhost:8081/swagger-ui/index.html