package com.cg.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.entity.Movie;
import com.cg.movie.exception.NameNotFoundException;
import com.cg.movie.response.ResponseInfo;
import com.cg.movie.service.MovieService;


@RestController
public class MovieController {
	@Autowired
	private MovieService movieServ;
	
	@PostMapping("/movie")
    ResponseEntity<ResponseInfo> insertMovie(@Valid @RequestBody Movie name,HttpServletRequest request){
		String msg=movieServ.addMovie(name);
	    ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
	    ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
	    return rentity;
	}
	
	@PutMapping("/movie/byId/{id}")
	ResponseEntity<ResponseInfo> deleteMovie(@Valid @PathVariable("id") Movie m, HttpServletRequest request){
		String msg=movieServ.deleteMovieByName(m);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
	
	@GetMapping("/moviee")
	List<Movie> getAllMovie(){
		return movieServ.getAllMovies();
	}
	
	@GetMapping("/movie/byGenre/{name}")
	Movie getMovieByCategory(@PathVariable("name") String name)throws NameNotFoundException {
		return movieServ.getMovieByCategory(name);
	}
	@PutMapping("/movies")
	ResponseEntity<ResponseInfo> updateMovie(@Valid @RequestBody Movie name, HttpServletRequest request){
		String msg=movieServ.updateMovie(name);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
	
	/*@RequestMapping(value="/addMovie")
	public String addMovie() {
		List<String> genre=new ArrayList<>();
		List<String> lang=new ArrayList<>();
		
		genre.add("Sci-Fi");
		genre.add("Drama");
		genre.add("Comedy");
		genre.add("Horror");
		genre.add("Satire");
		genre.add("Romance");
		genre.add("Politics");
		
		lang.add("Hindi");
		lang.add("English");
		lang.add("Telgu");
		lang.add("Punjabi");
		lang.add("Marathi");
		
	}*/
}
