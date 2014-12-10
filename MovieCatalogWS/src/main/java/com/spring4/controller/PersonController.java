package com.spring4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring4.entity.Person;
import com.spring4.service.IPersonService;

@RestController
@RequestMapping("/data/person")
public class PersonController {

	@Autowired
	private IPersonService personService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPersonDetail(@PathVariable long id) {
		Person p = personService.getPersonDetail(id);
		return p;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getPersons() {
		List<Person> persons = personService.getPersons();
		return persons;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Person add(@RequestBody Person person) {
		Person p = personService.saveOrUpdate(person);
		return p;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable long id) {
		Person p = new Person();
		p.setId(id);
		personService.removePerson(p);
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePerson(@PathVariable long id, @RequestBody Person person) {
    	person.setId(id);
    	personService.saveOrUpdate(person);
    }

	
}