package rs.cir9akovic.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.cir9akovic.bookstore.DAO.IUsersDAO;
import rs.cir9akovic.bookstore.entity.Users;

@Service
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private IUsersDAO usersDAO;
	
	@Override
	public List<Users> getUsers() {
		
		List<Users> users = usersDAO.getUsers();
		
		return users;
	}

	@Override
	public Users getUser(int id) {
		
		Users user = usersDAO.getUser(id);
		
		return user;
	}

	@Override
	public void saveOrUpdateUser(Users newUser) {
		
		usersDAO.saveOrUpdateUser(newUser);
	}

	@Override
	public void removeUser(int theId) {
		
		usersDAO.removeUser(getUser(theId));
	}

}
