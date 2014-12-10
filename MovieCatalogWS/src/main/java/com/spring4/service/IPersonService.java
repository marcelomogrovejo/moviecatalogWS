package com.spring4.service;

import java.util.List;

import com.spring4.entity.Person;

public interface IPersonService {
	
	/**
	 * Gets a person by id
	 * @param id
	 * @return
	 */
	Person getPersonDetail(Long id);

	/**
	 * List all persons
	 * @return
	 */
	List<Person> getPersons();
	
	/**
	 * Saves a person
	 * @param person
	 * @return
	 */
	Person saveOrUpdate(Person person);

	/**
	 * Removes a person by id
	 * @param id
	 */
	void removePerson(Person p);

	/* TODO:
	 * 		1. list persons paginated
	 */
}
