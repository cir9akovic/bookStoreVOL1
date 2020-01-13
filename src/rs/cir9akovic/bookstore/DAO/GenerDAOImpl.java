package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rs.cir9akovic.bookstore.entity.Geners;

@Repository
public class GenerDAOImpl implements IGenersDAO {

	// Inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Geners> getGeners() {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create query
		Query<Geners> theQuery = currentSession.createQuery("from Geners", Geners.class);
		
		// Execute query and get result list
		List<Geners> geners = theQuery.getResultList();
		
		return geners;
	}

	@Override
	@Transactional
	public Geners getGener(int theId) {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Find specific gener
		Geners gener = currentSession.get(Geners.class, theId);
		
		return gener;
	}

	@Override
	@Transactional
	public void saveOrUpdateGener(Geners newGener) {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save or Update Gener
		currentSession.saveOrUpdate(newGener);
		
	}

	@Override
	@Transactional
	public void removeGener(Geners oldGener) {
		
		// Current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// Save or Update Gener
		currentSession.remove(oldGener);
		
	}

}
