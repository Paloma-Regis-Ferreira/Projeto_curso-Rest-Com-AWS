package br.com.paloma.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paloma.data.vo.PersonVO;
import br.com.paloma.services.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id){
		return services.findById(id);
		
	}
	
	@GetMapping
	public List<PersonVO> findAll(){
		return services.findAll();
		
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person){
		return services.create(person);
		
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person){
		return services.update(person);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		services.delete(id);
		return ResponseEntity.ok().build();
		
	}
}