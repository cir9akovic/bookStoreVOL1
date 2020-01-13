package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Authors;

public interface IAuthorsDAO {
	
	public List<Authors> getAuthors();
	public Authors getAuthor(int theId);
	public void saveOrUpdateAuthor(Authors newAuthor);
	public void removeAuthor(Authors oldAuthor);
}
