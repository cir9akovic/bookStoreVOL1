package rs.cir9akovic.bookstore.service;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Geners;

public interface IGenersService {

	public List<Geners> getGeners();
	public Geners getGener(int theId);
	public void saveOrUpdateGener(Geners newGener);
	public void removeGener(int theId);
	
}
