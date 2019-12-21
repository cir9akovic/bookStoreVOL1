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

@Entity
@Table(name="geners") // mistyped in database
public class Geners {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	//Table relationships
	@OneToMany(mappedBy = "genre", cascade = CascadeType.ALL) // Refers to "genre" property in Books class
	private List<Books> books;
	
	//Constructors
	public Geners() {}

	public Geners(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// Methods
	
	//Method for bi-directional relationship
	
	public void addBook(Books book) {
		
		if(books != null) {
			
			books.add(book);
			
			book.setGener(this);
			
		}else {
			
			books = new ArrayList<>();
			
		}
	}

	
}
