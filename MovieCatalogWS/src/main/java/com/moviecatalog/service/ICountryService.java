package com.moviecatalog.service;

import java.util.List;

import com.moviecatalog.entity.Country;

public interface ICountryService {
	
	/**
	 * Gets a country by id
	 * @param id
	 * @return
	 */
	Country getCountry(Long id);

	/**
	 * List all countries
	 * @return
	 */
	List<Country> getCountries();
	
	/**
	 * Saves a country
	 * @param country
	 * @return
	 */
	Country saveOrUpdate(Country country);

	/**
	 * Removes a country
	 * @param country
	 */
	void removeCountry(Country country);

	/* TODO:
	 * 		1. list countries paginated
	 */
}
