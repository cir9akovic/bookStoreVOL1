package rs.cir9akovic.bookstore.service;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Books;

public interface IBooksService {

	public List<Books> getBooks();
	public Books getBook(int theId);
	public void saveOrUpdateBook(Books newBook);
	public void removeBook(int theId);
	public List<Books> getBooksWithUsers();
	public List<Books> getMostReadBook();
}
