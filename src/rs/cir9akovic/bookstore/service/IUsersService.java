package rs.cir9akovic.bookstore.service;

import java.util.List;

import rs.cir9akovic.bookstore.entity.Users;

public interface IUsersService {

	public List<Users> getUsers();
	public Users getUser(int id);
	public void saveOrUpdateUser(Users newUser);
	public void removeUser(int theId);
}
