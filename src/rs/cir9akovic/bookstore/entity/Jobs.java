package rs.cir9akovic.bookstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobs")
public class Jobs {
	
	@Id
	@Column(name="userID")
	private int id;
	
	@Column(name="jobTitle")
	private String jobTitle;
	
	@Column(name="description")
	private String description;
	
	@Column(name="salary")
	private int salary;
	
	// Table mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userID")
	@MapsId // Takes primary key form parent entity
	private Users user;
	
	// Constructors
	
	public Jobs() {}

	public Jobs(String jobTitle, String description, int salary) {
		this.jobTitle = jobTitle;
		this.description = description;
		this.salary = salary;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
