package com.moviecatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moviecatalog.entity.Movie;
import com.moviecatalog.service.IMovieService;

@RestController
@RequestMapping("/data/movie")
public class MovieController {

	@Autowired
	private IMovieService movieService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie getMovieDetail(@PathVariable long id) {
		Movie m = movieService.getMovieDetail(id);
		return m;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getMovies() {
		List<Movie> movies = movieService.getMovies();
		return movies;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie add(@RequestBody Movie movie) {
		Movie m = movieService.saveOrUpdate(movie);
		return m;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable long id) {
		Movie m = new Movie();
		m.setId(id);
		movieService.removeMovie(m);
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateMovie(@PathVariable long id, @RequestBody Movie movie) {
    	movie.setId(id);
    	movieService.saveOrUpdate(movie);
    }

	
}