package rs.cir9akovic.bookstore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message = "is required!")
	@Column(name="title")
	private String title;
	
	@NotEmpty(message = "is required!")
	@Column(name="doc")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // For formating to date field in database
	private String doc;
	
	@NotNull(message = "is required!")
	@Positive(message = "Pages must be positive number!")
	@Min(value = 10, message = "Book must have minimum 10 pages!") 
	@Column(name="pages")
	private int pages;
	
	
	//Table relationships
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) // If delete book don't delete author
	@JoinColumn(name="authorID")
	private Authors author;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) // If delete book don't delete genre
	@JoinColumn(name="genreID")
	private Geners genre;
	
	@ManyToMany(mappedBy = "books", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) // If delete book don't delete user
	private List<Users> users;
	

	//Constructors
	public Books() {}

	public Books(String title, String doc, int pages) {
		this.title = title;
		this.doc = doc;
		this.pages = pages;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
		this.author = author;
	}
	
	public Geners getGenre() {
		return genre;
	}

	public void setGenre(Geners genre) {
		this.genre = genre;
	}
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
}
