package br.com.paloma.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

import br.com.paloma.data.vo.BookVO;
import br.com.paloma.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Book EndPoint", description = "Description for book", tags = {"Book EndPoint"})
@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	@Autowired
	private BookService services;
	
	@ApiOperation (value = "Find book by id")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id){
		BookVO bookVO = services.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation (value = "Find all books recorded")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll(){
		List<BookVO> people = services.findAll();
		people.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		return people;
	}
	
	@ApiOperation (value = "create book")
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO book){
		BookVO bookVO =  services.create(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation (value = "update book")
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO book){
		BookVO bookVO =  services.update(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation (value = "delete book")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		services.delete(id);
		return ResponseEntity.ok().build();
		
	}
}
