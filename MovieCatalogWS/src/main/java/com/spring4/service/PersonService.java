package com.spring4.service;

import java.util.List;

import org.aspectj.runtime.internal.PerObjectMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring4.entity.Person;
import com.spring4.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person getPersonDetail(Long id){
		Person person = personRepository.findOne(id);
		return person;
	}
	
	@Override
	public List<Person> getPersons() {
		List<Person> persons = personRepository.findAll();
		return persons;
	}

	@Override
	public Person saveOrUpdate(Person person) {
		Person personCrud = null;
		if (person.getId() != null) {
			// Update
			personCrud = personRepository.findOne(person.getId());
			personCrud.setFirstName(person.getFirstName() != null? person.getFirstName() : personCrud.getFirstName());
			personCrud.setLastName(person.getLastName() != null? person.getLastName() : personCrud.getLastName());
			personCrud.setBirthday(person.getBirthday() != null? person.getBirthday() : personCrud.getBirthday());
		} else {
			// Create
			personCrud = person;
		}
		personCrud = personRepository.save(personCrud);
		return personCrud;
	}

	@Override
	public void removePerson(Person person) {
		personRepository.delete(person);
	}
	
}
