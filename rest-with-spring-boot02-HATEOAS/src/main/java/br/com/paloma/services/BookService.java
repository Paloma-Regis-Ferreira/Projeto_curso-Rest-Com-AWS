package br.com.paloma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paloma.converter.DozerConverter;
import br.com.paloma.data.model.Book;
import br.com.paloma.data.vo.BookVO;
import br.com.paloma.exception.ResourceNotFoundException;
import br.com.paloma.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public BookVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, BookVO.class);
	}

	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
	}

	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}

	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		entity.setAuthor(book.getAuthor());
		entity.setLauchDate(book.getLauchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	public void delete(Long id) {
		Book entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		repository.delete(entity);
	}
	

}
