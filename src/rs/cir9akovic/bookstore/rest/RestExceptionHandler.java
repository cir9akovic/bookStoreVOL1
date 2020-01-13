package rs.cir9akovic.bookstore.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	// Add an exception handler 	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(NotFoundException exc){
		
		// Create custom error response
		CustomErrorResponse error = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		
		// Return Response Entity
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
	
	// Add an exception handler for Generic Exception
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exc){
		
		// Create custom error response
		CustomErrorResponse error = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
			
		// Return Response Entity
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
}
 