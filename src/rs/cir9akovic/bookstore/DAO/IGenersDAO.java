package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Geners;

public interface IGenersDAO {
	
	public List<Geners> getGeners();
	public Geners getGener(int theId);
	public void saveOrUpdateGener(Geners newGener);
	public void removeGener(Geners oldGener);
}
