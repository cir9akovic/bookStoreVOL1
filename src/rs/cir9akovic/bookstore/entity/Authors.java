package rs.cir9akovic.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="authors")
public class Authors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message = "is required!")
	@Column(name="firstName")
	private String firstName;
	
	@NotEmpty(message = "is required!")
	@Column(name="lastName")
	private String lastName;
	
	@NotEmpty(message = "is required!")
	@Column(name="dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // For formating to date field in database
	// @Past good but not support String 
	private String dob;
	
	@Column(name="dod")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // For formating to date field in database
	// @PastOrPresent good but not support String 
	private String dod;
	
	@NotEmpty(message = "is required!")
	@Column(name="country")
	private String country;
	
	@NotEmpty(message = "is required!")
	@Column(name="gender")
	private String gender;
	
	//Table relationships
	@OneToMany(mappedBy="author", cascade=CascadeType.ALL) // Refers to "author" property in Books class
	private List<Books> books;
	

	// Constructors
	public Authors() {}

	public Authors(String firstName, String lastName, String dob, String dod, String country, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.dod = dod;
		this.country = country;
		this.gender = gender;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDod() {
		return dod;
	}

	public void setDod(String dod) {
		this.dod = dod;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}	
	
	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}
	
	// Methods
	
	//Method for bi-directional relationship
	public void addBook(Books book) {
	
		if(books != null) {
			
			books.add(book);
			
			book.setAuthor(this);
			
		}else {
			
			books = new ArrayList<>();
			
		}
	}
}
