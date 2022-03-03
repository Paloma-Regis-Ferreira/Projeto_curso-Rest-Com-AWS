package br.com.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paloma.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
