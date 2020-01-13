package rs.cir9akovic.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.cir9akovic.bookstore.DAO.IGenersDAO;
import rs.cir9akovic.bookstore.entity.Geners;

@Service
public class GenersServicesImpl implements IGenersService{

	@Autowired
	private IGenersDAO genersDAO;
	
	@Override
	public List<Geners> getGeners() {
		
		List<Geners> geners = genersDAO.getGeners();
		
		return geners;
	}

	@Override
	public Geners getGener(int theId) {
		
		Geners gener = genersDAO.getGener(theId);
		
		return gener;
	}

	@Override
	public void saveOrUpdateGener(Geners newGener) {
		
		genersDAO.saveOrUpdateGener(newGener);
	}

	@Override
	public void removeGener(int theId) {
		
		genersDAO.removeGener(getGener(theId));
	}

}
