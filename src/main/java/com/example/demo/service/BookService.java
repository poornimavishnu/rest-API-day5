package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	BookRepo br;
	
	public Book saveBook(Book b)
	{
		return br.save(b);
	}
	
	public List<Book> showBook(){
		return br.findAll();
	}
	public List<Book> savedetails(List<Book> b)
	{
		return (List<Book>)br.saveAll(b);
	}
	public Book changeinfo(Book b)
	{
		return br.saveAndFlush(b);
	}
	public void deleteinfo(Book b)
	{
		br.delete(b);
	}
	public void deleteid(int id)
	{
		br.deleteById(id);
	}
	public void deletepid(int id)
	{
		br.deleteById(id);
	}
	public Optional<Book> getid(int id) {
		return br.findById(id);
	}public String updatebyid(int id,Book b)
	{
		br.saveAndFlush(b);
		if(br.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}

}
