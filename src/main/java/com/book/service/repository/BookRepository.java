package com.book.service.repository;

public interface BookRepository {
	
		String getAllBooks();

		String createBook(String book);

		String deleteBook(Long id);

	}

