package rs.cir9akovic.bookstore.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.cir9akovic.bookstore.entity.Users;
import rs.cir9akovic.bookstore.service.IUsersService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	// Inject User service
	@Autowired
	private IUsersService usersService;
	
	// Get all Users
	@GetMapping("/users")
	public List<Users> getAuthors(){
		
		return usersService.getUsers();
	}
	
	// Get specific user
	@GetMapping("/user/{userId}")
	public Users getUser(@PathVariable int userId) {
		
		Users user = usersService.getUser(userId);
		
		if(user == null) {
			throw new NotFoundException("User id not found - " + userId);
		}
		
		return user;
	}
	
	// Add new User
	@PostMapping("/users")
	public Users addUser(@RequestBody Users user) {
		
		// Because Job need User for ID
		user.getJob().setUser(user);
		
		usersService.saveOrUpdateUser(user);
		
		return user;
	}
	
	// Update user
	@PutMapping("/users")
	public Users updateUser(@RequestBody Users user) {
		
		usersService.saveOrUpdateUser(user);
			
		return user;
	}
	
	// Update user
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		Users user = usersService.getUser(userId);
		
		if(user == null) {
			throw new NotFoundException("User id not found - " + userId);
		}else {
			usersService.removeUser(userId);
		}
		return "User with id:" + userId + " was deleted!";
	}
}
