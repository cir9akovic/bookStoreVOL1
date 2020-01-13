package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rs.cir9akovic.bookstore.entity.Books;

@Repository
public class BooksDAOimpl implements IBooksDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Books> getBooks() {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create query
		Query<Books> theQuery = currentSession.createQuery("from Books", Books.class);
		
		// Execute theQuery
		List<Books> books = theQuery.getResultList();
		
		return books;
	}

	@Override
	@Transactional
	public Books getBook(int theId) {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Find specific book
		Books book = currentSession.get(Books.class, theId);
		
		return book;
	}

	@Override
	@Transactional
	public void saveOrUpdateBook(Books newBook) {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save or Update the book
		currentSession.saveOrUpdate(newBook);
	}

	@Override
	@Transactional
	public void removeBook(Books oldBook) {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete the book
		currentSession.remove(oldBook);
	}

	@Override
	@Transactional
	public List<Books> getBooksWithUsers() {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Books> booksWithUsers = currentSession.createQuery("SELECT b FROM Books b JOIN FETCH b.users", Books.class).getResultList();
		
		return booksWithUsers;
	}
	
}
