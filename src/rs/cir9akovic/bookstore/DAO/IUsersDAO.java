package rs.cir9akovic.bookstore.DAO;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Users;

public interface IUsersDAO {

	public List<Users> getUsers();
	public Users getUser(int id);
	public void saveOrUpdateUser(Users newUser);
	public void removeUser(Users oldUser);
	
}
