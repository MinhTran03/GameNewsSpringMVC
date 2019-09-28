package com.springmvc.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Topic")
public class TopicEntity {

	@Id
	@Column(name = "topic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topic_id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	//----------------------------------------------------
	
	@OneToMany(mappedBy = "topic")
	private Set<PostEntity> posts;
	
	//----------------------------------------------------
	
	public Set<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
