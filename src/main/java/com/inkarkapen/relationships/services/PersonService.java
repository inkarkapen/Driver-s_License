package com.inkarkapen.relationships.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.relationships.models.Person;
import com.inkarkapen.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private static PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
    	this.personRepository = personRepository;
    }
    
    public static List<Person> allPersons() {
        return personRepository.findAll();
    }

	public static void newPerson(@Valid Person person) {
		personRepository.save(person);
	}

	public static Person findById(Long id) {
		return personRepository.findById(id).orElse(null);
	}
}
