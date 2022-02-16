package br.com.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paloma.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
