package rs.cir9akovic.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.cir9akovic.bookstore.DAO.IAuthorsDAO;
import rs.cir9akovic.bookstore.entity.Authors;

@Service
public class AuthorsServiceImpl implements IAuthorsService  {

	@Autowired
	private IAuthorsDAO authorsDAO;
	
	@Override
	public List<Authors> getAuthors() {
		
		List<Authors> authors = authorsDAO.getAuthors();
		
		return authors;
	}

	@Override
	public Authors getAuthor(int theId) {
		
		Authors author = authorsDAO.getAuthor(theId);
		
		return author;
	}

	@Override
	public void saveOrUpdateAuthor(Authors newAuthor) {
		
		authorsDAO.saveOrUpdateAuthor(newAuthor);
	}

	@Override
	public void removeAuthor(int theId) {
		
		authorsDAO.removeAuthor(getAuthor(theId));
	}

}
