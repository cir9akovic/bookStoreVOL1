package rs.cir9akovic.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.cir9akovic.bookstore.entity.Books;
import rs.cir9akovic.bookstore.entity.Jobs;
import rs.cir9akovic.bookstore.entity.Users;
import rs.cir9akovic.bookstore.service.IBooksService;
import rs.cir9akovic.bookstore.service.IUsersService;

@Controller
public class UserController {
	
	@Autowired
	private IUsersService usersService;
	
	@Autowired
	private IBooksService booksService;
	
	@GetMapping("/users")
	public String getUsersJobs(Model theModel) {
		
		// Get list from DAO
		List<Users> users = usersService.getUsers();
		
		// Add List to the model
		theModel.addAttribute("users", users);
		
		return "usersPage";
	}
	
	@GetMapping("/addUser")
	public String addUser(Model theModel) {
		
		// Create new objects
		Users theUser = new Users();
		Jobs theJob = new Jobs();
		
		// Attach them to Model
		theModel.addAttribute("user", theUser);
		theModel.addAttribute("job", theJob);
		
		return "addUser";
	}
	
	@GetMapping("/modifyUser")
	public String updateUser(@RequestParam("UserId") int theId, Model theModel) {
		
		// Get specific user
		Users user = usersService.getUser(theId);
		
		// Attach user object to the model
		theModel.addAttribute("user", user);
		
		return "modifyUser";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") Users user) {
		
		user.getJob().setId(user.getId()); //Must know the id of job to update
		usersService.saveOrUpdateUser(user);
		
		return "redirect:/users";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") Users newUser, @ModelAttribute("job") Jobs newJob) {
		
		newUser.setJob(newJob);
		newJob.setUser(newUser); // Because newJob must know from who to take primary key
		
		usersService.saveOrUpdateUser(newUser);
		
		return "redirect:/users";
	}
	
	@GetMapping("/removeUser")
	public String removeUser(@RequestParam("UserId") int theID) {
		
		// Remove specific object in the database
		usersService.removeUser(theID);
		
		return "redirect:/users";
	}
	
	@GetMapping("/userReadBooks")
	public String userReadBooks(Model theModel) {
		
		// Get all users and books
		List<Users> users = usersService.getUsers();
		List<Books> books = booksService.getBooks();
		
		// Attach them to the model
		theModel.addAttribute("users", users);
		theModel.addAttribute("books", books);
		
		return "userReadBooks";
	}
	
	public String saveReadBook() {
	
		
		
		return "redirect:/userReadBooks";
	}
}
