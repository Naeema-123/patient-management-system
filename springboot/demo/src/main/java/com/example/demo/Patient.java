package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "patient")
public class Patient {
	 @Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY)
	
public long id;
	 
	 @Column(name ="first_name")
	 public String firstName;
	 
	 public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Column(name ="last_name")
 public String lastName;


	 @Column(name ="age")
	 public String age;
 
 public Patient() {
 }
	 public Patient(String firstName, String lastName, String appointmentDate){
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			 }
 public long getId() {
	return id;
}
   public void setId(long id) {
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

}
