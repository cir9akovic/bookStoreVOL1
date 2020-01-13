package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Books;

public interface IBooksDAO {

	public List<Books> getBooks();
	public Books getBook(int theId);
	public void saveOrUpdateBook(Books newBook);
	public void removeBook(Books oldBook);
	public List<Books> getBooksWithUsers();
}
