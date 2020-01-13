package rs.cir9akovic.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home") // Request mapping allow GET and POST requests
	public String redirectPage() {
		return "redirect:/";
	}
	
	@RequestMapping("/") // Request mapping allow GET and POST requests
	public String showHomePage() {
		return "home";
	}
}
