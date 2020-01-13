package rs.cir9akovic.bookstore.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.cir9akovic.bookstore.entity.Authors;
import rs.cir9akovic.bookstore.entity.Books;
import rs.cir9akovic.bookstore.entity.Geners;
import rs.cir9akovic.bookstore.service.IAuthorsService;
import rs.cir9akovic.bookstore.service.IBooksService;
import rs.cir9akovic.bookstore.service.IGenersService;

@Controller
public class BookController {

	// Resolve issue for validation 
		// Remove leading and trailing whitespace
		// Pre-processor
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
	
	// Inject booksDAO
	@Autowired
	IBooksService booksService;
	
	// Inject genersDAO
	@Autowired
	IGenersService genersService;
	
	// Inject authorsDAO
	@Autowired
	IAuthorsService authorsService;
	
	@GetMapping("/books")
	public String getBooks(Model theModel) {
		
		// Get list from DAO
		List<Books> theBooks = booksService.getBooks();
				
		// Add Authors to the model
		theModel.addAttribute("books", theBooks);
		
		return "booksPage";
	}
	
	@GetMapping("/addBook")
	public String addBook(Model theModel) {
		
		// Create new books object
		Books newBook = new Books();
		
		// Get all genres
		List<Geners> genersList = genersService.getGeners();
	
		// Get all authors
		List<Authors> authorsList = authorsService.getAuthors();
	
		// Attach objects to the model
		theModel.addAttribute("newBook", newBook);
		theModel.addAttribute("geners", genersList);
		theModel.addAttribute("authors", authorsList);
		
		return "addBook";
	}
	
	@GetMapping("/modifyBook")
	public String modifyBook(@RequestParam("bookId") int theID, Model theModel) {
		
		// Get specific book
		Books book = booksService.getBook(theID);
		
		// Get all genres
				List<Geners> genersList = genersService.getGeners();
			
				// Get all authors
				List<Authors> authorsList = authorsService.getAuthors();
			
				// Attach objects to the model
				theModel.addAttribute("book", book);
				theModel.addAttribute("geners", genersList);
				theModel.addAttribute("authors", authorsList);
		
		return "modifyBook";
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@RequestParam("id") Integer id, @RequestParam("title") String title, @RequestParam("doc") String doc, @RequestParam("pages") int pages, @RequestParam("author") int authorID, @RequestParam("genre") int genreID) {
		
		// Handmade object because @ModelAttribute can't convert String to object
		Books book = new Books(title, doc, pages);
		Authors author = authorsService.getAuthor(authorID);
		Geners genre = genersService.getGener(genreID);
				
		book.setId(id);
		book.setAuthor(author);
		book.setGenre(genre);
		
		// Update book object in database
		booksService.saveOrUpdateBook(book);
		
		return "redirect:/books";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@RequestParam("title") String title, @RequestParam("doc") String doc, @RequestParam("pages") int pages, @RequestParam("author") int authorID, @RequestParam("genre") int genreID) {
		
			// Handmade object because @ModelAttribute can't convert String to object
			Books newBook = new Books(title, doc, pages);
			Authors author = authorsService.getAuthor(authorID);
			Geners genre = genersService.getGener(genreID);
				
			newBook.setAuthor(author);
			newBook.setGenre(genre);
		
			// Update book object in database
			booksService.saveOrUpdateBook(newBook);
		
			return "redirect:/books";
	}
	
	@GetMapping("/removeBook")
	public String removeBook(@RequestParam("bookId") int theID) {
		
		//Remove specific book
		booksService.removeBook(theID);
		
		return "redirect:/books";
	}
	
	@GetMapping("/mostReadBook")
	public String getMostReadBook(Model theModel) {
		
		List<Books> mostReadBook = booksService.getMostReadBook();
		
		theModel.addAttribute("mostReadBook", mostReadBook);
		
		return "mostReadBook";
	}
	
}
