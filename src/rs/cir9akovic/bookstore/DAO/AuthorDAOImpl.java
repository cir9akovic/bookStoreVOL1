package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rs.cir9akovic.bookstore.entity.Authors;

@Repository
public class AuthorDAOImpl implements IAuthorsDAO {

	// Inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Authors> getAuthors() {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create query
		Query<Authors> theQuery = currentSession.createQuery("from Authors", Authors.class);
		
		// Execute query and get result list
		List<Authors> authors = theQuery.getResultList();
		
		return authors;
	}
	
	@Override
	@Transactional
	public Authors getAuthor(int theId) {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Get specific author
		Authors author = currentSession.get(Authors.class, theId);
		
		return author;
	}
	
	@Override
	@Transactional
	public void saveOrUpdateAuthor(Authors newAuthor) {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save new Author
		currentSession.saveOrUpdate(newAuthor); // Hibernate method that if don't have ID create a new Author or otherwise update existing one
		
	}
	
	@Override
	@Transactional
	public void removeAuthor(Authors oldAuthor) {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Remove old Author
		currentSession.remove(oldAuthor);
		
	}
	
	

}
