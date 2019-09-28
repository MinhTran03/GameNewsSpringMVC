package com.springmvc.models;

import java.time.LocalDate;
import com.springmvc.entities.AuthorEntity;

public class Author {
	
	private int authorId;
	
	private String address;
	
	private LocalDate birthday;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String image;
	
	private String phoneNumber;
	
	private LocalDate registrationDay;
	
	private int totalPost;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getRegistrationDay() {
		return registrationDay;
	}

	public void setRegistrationDay(LocalDate registrationDay) {
		this.registrationDay = registrationDay;
	}

	public int getTotalPost() {
		return totalPost;
	}

	public void setTotalPost(int totalPost) {
		this.totalPost = totalPost;
	}
	public void entity2model(AuthorEntity entity) {
		this.setAddress(entity.getAddress());
		this.setAuthorId(entity.getAuthor_id());
		this.setBirthday(entity.getBirthday());
		this.setEmail(entity.getEmail());
		this.setFirstName(entity.getFirst_name());
		this.setImage(entity.getImage());
		this.setLastName(entity.getLast_name());
		this.setPhoneNumber(entity.getPhone_number());
		this.setRegistrationDay(entity.getRegistrationday());
		this.setTotalPost(entity.getTotal_post());
	}
}
