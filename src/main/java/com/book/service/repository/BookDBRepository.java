package com.book.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.book.domain.Books;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class BookDBRepository implements BookRepository {
	
	private static final Logger LOGGER = Logger.getLogger(BookDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllBooks() {
		LOGGER.info("Book=DBRepository getAllBooks");
		Query query = manager.createQuery("Select a FROM Book a");
		Collection<Books> books = (Collection<Books>) query.getResultList();
		return util.getJSONForObject(books);
	}

	@Transactional(REQUIRED)
	public String createBook(String book) {
		LOGGER.info("BookDBRepository createBook");
		Books anBook = util.getObjectForJSON(book, Books.class);
		manager.persist(anBook);
		return "{\"message\": \"book has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteBook(short id) {
		LOGGER.info("BookDBRepository deleteBook");
		Books bookInDB = findBook(id);
		if (bookInDB != null) {
			manager.remove(bookInDB);
			return "{\"message\": \"book sucessfully deleted\"}";
		}
		return "{\"message\": \"book not found\"}";

	}

	private Books findBook(short id) {
		LOGGER.info("BookDBRepository findBook");
		return manager.find(Books.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	public String deleteBook(Long id) {
	
		return null;
	}

}