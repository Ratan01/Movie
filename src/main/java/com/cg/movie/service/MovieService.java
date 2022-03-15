package com.cg.movie.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.entity.Movie;
import com.cg.movie.exception.NameNotFoundException;
import com.cg.movie.repository.MovieRepository;


@Service("movieServ")
@Transactional
public class MovieService {
	@Autowired
	private MovieRepository movieRepo;
	
	//adding
	public String addMovie(Movie name) {
		movieRepo.save(name);
		return "Inserted Successfully!!!";
	}
	//deleting
	public String deleteMovieByName(Movie m) {
		Optional<Movie> op = movieRepo.findByMovieName(m);
		if(op.isPresent()) {
			movieRepo.deleteByMovieName(m);
			return "Deleted Successfully!!!";
		}
		else
			 throw new NameNotFoundException("No Movie found for this name: "+m);
	}
	//all movie
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	public Movie getMovieByCategory(String movie)throws NameNotFoundException {
		Optional<Movie> op=movieRepo.findByGenre(movie);
		if(op.isPresent())
			return op.get();
		else
			throw new NameNotFoundException("No Movie found for this name: "+movie);
	}
	//updating
	public String updateMovie(Movie e) {
		movieRepo.save(e);
		return "Updated Successfully!!!";
	}
	
	/*
	public Movie save(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public Movie findAll(){
		return (Movie) movieRepo.findAll();
	}

	public Optional<String> find(Integer movieId) {
		return movieRepo.findById(movieId);
	}
	
	public Optional<Movie> findByCategory(String movie){
		return Optional.find
	}
	public Movie remove(Integer movieId) {
		return movieRepo.remove(movieId);
	}
	*/
}
