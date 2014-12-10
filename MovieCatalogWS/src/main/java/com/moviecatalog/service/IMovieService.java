package com.moviecatalog.service;

import java.util.List;

import com.moviecatalog.entity.Movie;

public interface IMovieService {
	
	/**
	 * Gets a movie by id
	 * @param id
	 * @return
	 */
	Movie getMovieDetail(Long id);

	/**
	 * List all movies
	 * @return
	 */
	List<Movie> getMovies();
	
	/**
	 * Saves a movie
	 * @param movie
	 * @return
	 */
	Movie saveOrUpdate(Movie movie);

	/**
	 * Removes a movie by id
	 * @param id
	 */
	void removeMovie(Movie p);

	/* TODO:
	 * 		1. list movies paginated
	 */
}
