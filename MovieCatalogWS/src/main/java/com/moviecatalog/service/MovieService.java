package com.moviecatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecatalog.entity.Movie;
import com.moviecatalog.repository.MovieRepository;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public Movie getMovieDetail(Long id){
		Movie movie = movieRepository.findOne(id);
		return movie;
	}
	
	@Override
	public List<Movie> getMovies() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}

	@Override
	public Movie saveOrUpdate(Movie movie) {
		Movie movieCrud = null;
		if (movie.getId() != null) {
			// Update
			movieCrud = movieRepository.findOne(movie.getId());
			movieCrud.setFirstName(movie.getFirstName() != null? movie.getFirstName() : movieCrud.getFirstName());
			movieCrud.setLastName(movie.getLastName() != null? movie.getLastName() : movieCrud.getLastName());
			movieCrud.setBirthday(movie.getBirthday() != null? movie.getBirthday() : movieCrud.getBirthday());
		} else {
			// Create
			movieCrud = movie;
		}
		movieCrud = movieRepository.save(movieCrud);
		return movieCrud;
	}

	@Override
	public void removeMovie(Movie movie) {
		movieRepository.delete(movie);
	}
	
}
