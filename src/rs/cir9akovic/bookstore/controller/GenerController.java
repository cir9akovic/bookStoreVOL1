package rs.cir9akovic.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.cir9akovic.bookstore.entity.Geners;
import rs.cir9akovic.bookstore.service.IGenersService;

@Controller
public class GenerController {
	
	// Inject GenersDAO dependency interface
	@Autowired
	private IGenersService genersService;
	
	@GetMapping("/geners")
	public String getGeners(Model theModel) {
		
		// Get geners from DAO
		List<Geners> geners = genersService.getGeners();
		
		// Attach to the model
		theModel.addAttribute("geners", geners);
		
		return "genersPage";
	}
	
	@GetMapping("/addGener")
	public String addGener(Model theModel) {
		
		// Create new object
		Geners newGener = new Geners();
		
		// Attach new object to the Model and send them to the page
		theModel.addAttribute("newGener", newGener);
		
		return "addGener";
	}
	
	@GetMapping("/modifyGener")
	public String modifyGener(@RequestParam("generId") int generId, Model theModel) {
		
		// Find specific gener
		Geners gener = genersService.getGener(generId);
		
		// Attach new object to the Model and send them to the page
		theModel.addAttribute("gener", gener);
		
		return "modifyGener";
	} 

	
	@PostMapping("/saveOrUpdateGener")
	public String saveOrUpdateGener(@ModelAttribute("gener") Geners newGener) {
		
		// Save of update new gener objet in database 
		genersService.saveOrUpdateGener(newGener);
		
		return "redirect:/geners";
	}
	
	@GetMapping("/removeGener")
	public String removeGener(@RequestParam("generId") int generId) {
		
		// Remove specofic gener in database
		genersService.removeGener(generId);
		
		return "redirect:/geners";
	} 
}
