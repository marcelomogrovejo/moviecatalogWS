package com.moviecatalog.service;

import java.util.List;

import com.moviecatalog.entity.Format;

public interface IFormatService {
	
	/**
	 * Gets a format by id
	 * @param id
	 * @return
	 */
	Format getFormat(Long id);

	/**
	 * List all formats
	 * @return
	 */
	List<Format> getFormats();
	
	/**
	 * Saves a format
	 * @param format
	 * @return
	 */
	Format saveOrUpdate(Format format);

	/**
	 * Removes a format
	 * @param format
	 */
	void removeFormat(Format format);

	/* TODO:
	 * 		1. list formats paginated
	 */
}
