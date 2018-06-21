package com.book.intergration;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/book")
public class BookEndPoint {

	private static final Logger LOGGER = Logger.getAnonymousLogger();
	
	@Inject
	private BookEndPoint service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllBook() {
		LOGGER.info("BookEndPoint + getAllBooks");
		return service.getAllBook();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addBook(String book) {
		LOGGER.info("BookEndPoint + addBook");
		return service.addBook(book);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateBook(@PathParam("id") short id, String book) {
		LOGGER.info("BookEndPoint + deleteBook");
		return service.updateBook(id, book);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBook(@PathParam("id") short id) {
		LOGGER.info("BookEndPoint + setService");
		return service.deleteBook(id);

	}

	public <bookService> void setService(bookService service) {
		LOGGER.info("BookEndpoint + setService");
		this.service = (BookEndPoint) service;
	}

}


