package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rs.cir9akovic.bookstore.entity.Users;

@Repository
public class UsersImpl implements IUsersDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Users> getUsers() {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create query
		Query<Users> theQuery = currentSession.createQuery("from Users", Users.class);
		
		// Execute theQuery
		List<Users> users = theQuery.getResultList();
		
		return users;
	}

	@Override
	@Transactional
	public Users getUser(int theId) {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Get specific User
		Users user = currentSession.get(Users.class, theId);
			
		return user;
	}

	@Override
	@Transactional
	public void saveOrUpdateUser(Users newUser) {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// Save or Update the book
		currentSession.saveOrUpdate(newUser);
		
	}

	@Override
	@Transactional
	public void removeUser(Users oldUser) {
		
		// Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Remove user
		currentSession.remove(oldUser);
		
	}


}
