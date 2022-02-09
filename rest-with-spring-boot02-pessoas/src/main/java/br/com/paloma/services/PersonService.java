package br.com.paloma.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.paloma.model.Person;

@Service
//com a notação o spring faz a injeção de dependencia sem precisar dar "New" em outra classe
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong(); //vai simular um id do banco
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Paloma");
		person.setLastName("Regis");
		person.setAddress("rua 123");
		person.setGender("female");
		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i < 8; i ++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Person Last name" + i);
		person.setAddress("rua no Brasil" + i);
		person.setGender("female");
		return person;
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
	}
	
}
