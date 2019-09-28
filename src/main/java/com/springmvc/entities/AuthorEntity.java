package com.springmvc.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Author")
public class AuthorEntity {

	@Id
	@Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int author_id;
	
	@Column(nullable = false, length = 50)
	private String first_name;
	
	@Column(nullable = false, length = 50)
	private String last_name;
	
	@Column(nullable = false)
	private LocalDate birthday;
	
	@Column(nullable = false)
	private LocalDate registration_day;
	
	@Column(nullable = false)
	private int total_post;
	
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false, length = 10)
	private String phone_number;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String address;
	
	//---------------------------------------
	
	@OneToMany(mappedBy="author")
    public Set<PostEntity> posts;
	
	//---------------------------------------
	
	public Set<PostEntity> getPosts() {
		return posts;
	}
	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public LocalDate getRegistrationday() {
		return registration_day;
	}
	public void setRegistrationday(LocalDate registrationday) {
		this.registration_day = registrationday;
	}
	public int getTotal_post() {
		return total_post;
	}
	public void setTotal_post(int total_post) {
		this.total_post = total_post;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
