package rs.cir9akovic.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.cir9akovic.bookstore.DAO.IBooksDAO;
import rs.cir9akovic.bookstore.entity.Books;

@Service
public class BooksServiceImpl implements IBooksService{

	@Autowired
	private IBooksDAO booksDAO;
	
	@Override
	public List<Books> getBooks() {
		
		List<Books> books = booksDAO.getBooks();
		
		return books;
	}

	@Override
	public Books getBook(int theId) {
		
		Books book = booksDAO.getBook(theId);
		
		return book;
	}

	@Override
	public void saveOrUpdateBook(Books newBook) {
		
		booksDAO.saveOrUpdateBook(newBook);
	}

	@Override
	public void removeBook(int theId) {
	
		booksDAO.removeBook(getBook(theId));
	}

	@Override
	public List<Books> getBooksWithUsers() {
		
		List<Books> booksWithUsers = booksDAO.getBooksWithUsers();
		
		return booksWithUsers;
	}

	@Override
	public List<Books> getMostReadBook() {
		
		// Get all books
		List<Books> books = booksDAO.getBooksWithUsers();
		
		// Find book that have most readers
				int max = 0;
				int index = -1;
				
				for(int i=0; i < books.size(); i++) {
					if(books.get(i).getUsers().size() > max) {
						max = books.get(i).getUsers().size();
						index = i;
					}	
				}
				
				List<Books> mostReadBook = new ArrayList<>();
				mostReadBook.add(books.get(index));
				
				for(int i=0; i < books.size(); i++) {
					if(books.get(i) != books.get(index) && books.get(i).getUsers().size() == books.get(index).getUsers().size()){
						mostReadBook.add(books.get(i));
					}
				}
		
		return mostReadBook;
	}

}
