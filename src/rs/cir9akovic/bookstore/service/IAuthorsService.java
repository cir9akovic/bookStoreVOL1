package rs.cir9akovic.bookstore.service;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Authors;

public interface IAuthorsService {
	
	public List<Authors> getAuthors();
	public Authors getAuthor(int theId);
	public void saveOrUpdateAuthor(Authors newAuthor);
	public void removeAuthor(int theId);
}
