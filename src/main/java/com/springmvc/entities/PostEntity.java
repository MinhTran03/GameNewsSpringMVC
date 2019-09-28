package com.springmvc.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Post")
public class PostEntity {
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int post_id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private LocalDate time;
	
	@Column(nullable = false)
	private int views;
	
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String short_title;
	
	//-----------------------------------------------------------------------------------
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Post_Tag", joinColumns = { 
			@JoinColumn(name = "post_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "tag_id", 
					nullable = false, updatable = false) })
	private Set<TagEntity> tags;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private AuthorEntity author;
	
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	private TopicEntity topic;
	
	@OneToMany(mappedBy = "post")
	private Set<CommentEntity> comments;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_content_id", referencedColumnName = "post_content_id")
	private PostContentEntity postContent;
	
	//-----------------------------------------------------------------------------------
	
	public String getShortTitle() {
		return short_title;
	}
	public void setShortTitle(String short_title) {
		this.short_title = short_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PostContentEntity getPostContentEntity() {
		return postContent;
	}
	public void setPostContentEntity(PostContentEntity postContentEntity) {
		this.postContent = postContentEntity;
	}
	public TopicEntity getTopic() {
		return topic;
	}
	public void setTopic(TopicEntity topic) {
		this.topic = topic;
	}
	public AuthorEntity getAuthor() {
		return author;
	}
	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<TagEntity> getTags() {
		return tags;
	}
	public void setTags(Set<TagEntity> tags) {
		this.tags = tags;
	}
	public Set<CommentEntity> getComments() {
		return comments;
	}
	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}
}
