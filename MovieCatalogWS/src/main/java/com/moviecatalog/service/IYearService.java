package com.moviecatalog.service;

import java.util.List;

import com.moviecatalog.entity.Year;

public interface IYearService {
	
	/**
	 * Gets a year by id
	 * @param id
	 * @return
	 */
	Year getYear(Long id);

	/**
	 * List all years
	 * @return
	 */
	List<Year> getYears();
	
	/**
	 * Saves a year
	 * @param year
	 * @return
	 */
	Year saveOrUpdate(Year year);

	/**
	 * Removes a year
	 * @param year
	 */
	void removeYear(Year year);

	/* TODO:
	 * 		1. list years paginated
	 */
}
