package rs.cir9akovic.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.cir9akovic.bookstore.DAO.IAuthorDAO;
import rs.cir9akovic.bookstore.entity.Authors;

@Controller
public class AuthorController {

	// Inject the AuthorDAO
	@Autowired
	private IAuthorDAO authorDAO;
	
	@GetMapping("/authors") // Allow only GET request
	public String getAuthors(Model theModel) {
		
		// Get list from DAO
		List<Authors> theAuthors = authorDAO.getAuthors();
		
		// Add Authors to the model
		theModel.addAttribute("authors", theAuthors);
		
		return "authorsPage";
	}
	
	@GetMapping("/addAuthor")
	public String addAuthor(Model theModel) {
		
		Authors theAuthor = new Authors();
		
		theModel.addAttribute("author", theAuthor);
		
		return "addAuthor";
	}
	
	@PostMapping("/saveAuthor") // Allow only POST request
	public String saveOrUpdateAuthor(@ModelAttribute("author") Authors newAuthor) {
		
		authorDAO.saveOrUpdateAuthor(newAuthor);
		
		return "redirect:/authors";
	}
	
	@GetMapping("/modifyAuthor")
	public String modifyAuthor(@RequestParam("authorId") int theID, Model theModel) {
		
		// Get Author with specific ID
		Authors author = authorDAO.getAuthor(theID);
		
		// Add Author to the model
		theModel.addAttribute("author", author);
		
		return "modifyAuthor";
	}
	
	@GetMapping("/removeAuthor")
	public String removeAuthor(@RequestParam("authorId") int theID, Model theModel) {
	
		Authors author = authorDAO.getAuthor(theID);
		
		authorDAO.removeAuthor(author);
		
		return "redirect:/authors";
		
	}
}
