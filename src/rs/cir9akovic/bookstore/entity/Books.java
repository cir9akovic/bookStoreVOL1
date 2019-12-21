package rs.cir9akovic.bookstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="doc")
	private String doc;
	
	@Column(name="pages")
	private int pages;
	
	
	//Table relationships
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) // If delete book don't delete author
	@JoinColumn(name="authorID")
	private Authors author;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) // If delete book don't delete genre
	@JoinColumn(name="genreID")
	private Geners genre;


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
	
	public Geners getGener() {
		return genre;
	}

	public void setGener(Geners genre) {
		this.genre = genre;
	}
}
