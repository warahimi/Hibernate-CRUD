package com.etity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Mapping out entity class to our database table
@Entity
@Table(name = "employee")
public class Employee {
	//Creating fields/variables and mapping to databas table columns
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="fist_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="course")
	private String course;
	
	@Column(name = "email")
	private String email;
	
	// Generating Constructors
	public Employee() {
	}

	public Employee(String firstName, String lastName, String course, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.email = email;
	}
	
	// Generate Getters and Setters

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", course=" + course
				+ ", email=" + email + "]";
	}
	
	
	
	
	

}
