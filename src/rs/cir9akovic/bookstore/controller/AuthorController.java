package rs.cir9akovic.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.cir9akovic.bookstore.entity.Authors;
import rs.cir9akovic.bookstore.service.IAuthorsService;

@Controller
public class AuthorController {

	// Resolve issue for validation 
	// Remove leading and trailing whitespace
	// Pre-processor
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	// Inject the AuthorService
	@Autowired
	private IAuthorsService authorsService;
		
	@GetMapping("/authors") // Allow only GET request
	public String getAuthors(Model theModel) {
		
		// Get list from DAO
		List<Authors> theAuthors = authorsService.getAuthors();
		
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
	
	@GetMapping("/modifyAuthor")
	public String modifyAuthor(@RequestParam("authorId") int theID, Model theModel) {
		
		// Get Author with specific ID
		Authors author = authorsService.getAuthor(theID);
		
		// Add Author to the model
		theModel.addAttribute("author", author);
		
		return "modifyAuthor";
	}
	
	@PostMapping("/saveOrUpdateAuthor") // Allow only POST request
	public String saveOrUpdateAuthor(@Valid @ModelAttribute("author") Authors newAuthor, BindingResult theBidingResults) {
		
		if(!theBidingResults.hasErrors()){
		
			// Save or update author object in database
			authorsService.saveOrUpdateAuthor(newAuthor);  // Hibernate method that if don't have ID create a new Author or otherwise update existing one
		
			return "redirect:/authors";
		}else {
			return "addAuthor";
		}
	}
	
	@GetMapping("/removeAuthor")
	public String removeAuthor(@RequestParam("authorId") int theID) {
		
		// Remove specific object in the database
		authorsService.removeAuthor(theID);
		
		return "redirect:/authors";
	}
}
