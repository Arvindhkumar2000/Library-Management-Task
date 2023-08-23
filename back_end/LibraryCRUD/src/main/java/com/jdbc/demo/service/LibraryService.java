package com.jdbc.demo.service;


import com.jdbc.demo.model.BooksModel;
import com.jdbc.demo.model.Response;
import com.jdbc.demo.model.libraryModel;

public interface LibraryService {

	public Response createUser(libraryModel values);
	
	public Response insertBooks(BooksModel values);
	
	public Response getAllUser();
	
	public Response getAllBooks();
	
	public Response getOneUser(String MemberID);

	
}
