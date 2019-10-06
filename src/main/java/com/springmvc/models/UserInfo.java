package com.springmvc.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.springmvc.entities.UserEntity;

public class UserInfo {
	
	private int userId;
	private String address;
	private LocalDate birthday;
	
	@NotBlank(message = "Please enter your email")
	private String email;
	
	private String firstName;
	private String lastName;
	private String image = "/lib/user/default.jpg";
	private String phoneNumber;
	private LocalDate registrationDay;
	private int totalPost;
	
	@NotBlank(message = "Password is requied")
	private String password;

	public UserInfo() {
		super();
	}

	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public void entity2model(UserEntity entity) {
		this.setAddress(entity.getAddress());
		this.setUserId(entity.getUser_id());
		this.setBirthday(entity.getBirthday());
		this.setEmail(entity.getEmail());
		this.setFirstName(entity.getFirst_name());
		this.setImage(entity.getImage());
		this.setLastName(entity.getLast_name());
		this.setPhoneNumber(entity.getPhone_number());
		this.setRegistrationDay(entity.getRegistration_day());
		this.setTotalPost(entity.getTotal_post());
	}
	
	public void entity2modelMode(UserEntity entity) {
		this.setUserId(entity.getUser_id());
		this.setFirstName(entity.getFirst_name());
		this.setImage(entity.getImage());
		this.setLastName(entity.getLast_name());
	}
}
