package com.moviecatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviecatalog.entity.Year;

public interface YearRepository extends JpaRepository<Year, Long>{

}
