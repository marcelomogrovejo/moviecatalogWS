package com.moviecatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviecatalog.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
