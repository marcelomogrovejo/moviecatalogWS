package com.moviecatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviecatalog.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
