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
			movieCrud.setTitle(movie.getTitle() != null? movie.getTitle() : movieCrud.getTitle());
			movieCrud.setOverview(movie.getOverview() != null? movie.getOverview() : movieCrud.getOverview());
			movieCrud.setPicture(movie.getPicture() != null? movie.getPicture() : movieCrud.getPicture());
			movieCrud.setTrailer(movie.getTrailer() != null? movie.getTrailer() : movieCrud.getTrailer());
			movieCrud.setRanking(movie.getRanking() != null? movie.getRanking() : movieCrud.getRanking());
			movieCrud.setDate(movie.getDate() != null? movie.getDate() : movieCrud.getDate());
			movieCrud.setYear(movie.getYear() != null? movie.getYear() : movieCrud.getYear());
			movieCrud.setCountry(movie.getCountry() != null? movie.getCountry() : movieCrud.getCountry());
			movieCrud.setDirector(movie.getDirector() != null? movie.getDirector() : movieCrud.getDirector());
			movieCrud.setFormat(movie.getFormat() != null? movie.getFormat() : movieCrud.getFormat());
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
