package br.com.paloma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paloma.converter.DozerConverter;
import br.com.paloma.data.model.Person;
import br.com.paloma.data.vo.PersonVO;
import br.com.paloma.exception.ResourceNotFoundException;
import br.com.paloma.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		repository.delete(entity);
	}
	
}
