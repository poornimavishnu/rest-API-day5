package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class Control {
	@Autowired
	BookService bser;
	
	@PostMapping("add")
	public Book add(@RequestBody Book b)
	{
		return bser.saveBook(b);
	}
	@PostMapping("/")
	public boolean addDet(@RequestBody List<Book> b)
	{
		return bser.savedetails(b)!=null;
	}
	@GetMapping("/")
	public List<Book> show()
	{
		return bser.showBook();
	}
	@GetMapping("{id}")
	public Optional<Book> showid(@PathVariable int id) {
		return bser.getid(id);
	}
	
	@PutMapping("/")
	public Book modify(@RequestBody Book b) {
		return bser.changeinfo(b);
	}
	@DeleteMapping("/{id}")
	public void delid(@PathVariable int id) {
		bser.deleteid(id);
	}
	@PutMapping("/{id}")
	public String modbyid(@PathVariable int id,@RequestBody Book b) {
		return bser.updatebyid(id, b);
	}


}