package com.jdbc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.demo.dao.LibraryDao;
import com.jdbc.demo.model.BooksModel;
import com.jdbc.demo.model.Response;
import com.jdbc.demo.model.libraryModel;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class LibraryController {
	
	@Autowired
	LibraryDao dao;

	

	
	@PostMapping("/create")
	public ResponseEntity<Response>createUser(@RequestBody libraryModel values){
	return ResponseEntity.ok(dao.createUser(values));
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Response>insertBooks(@RequestBody BooksModel values){
		return ResponseEntity.ok(dao.insertBooks(values));
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<Response>getAllUser(){
		return ResponseEntity.ok(dao.getAllUser());
	}
	
	@GetMapping("/getbooks")
	public ResponseEntity<Response>getAllBooks(){
		return ResponseEntity.ok(dao.getAllBooks());
	}
	
	@GetMapping("/getOneUser")
	public ResponseEntity<Response>getOneUser(@RequestParam String MemberID){
		return ResponseEntity.ok(dao.getOneUser(MemberID));
		}
	@GetMapping("/getOneBook")
	public ResponseEntity<Response>getOneBook(@RequestParam String ISBN){
		return ResponseEntity.ok(dao.getOneBook(ISBN));
	}
}
