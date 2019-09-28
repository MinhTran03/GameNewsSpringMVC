package com.springmvc.models;

import com.springmvc.entities.TopicEntity;

public class Topic {
	
	private int topicId;
	
	private String name;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void entity2model(TopicEntity entity) {
		this.setTopicId(entity.getTopic_id());
		this.setName(entity.getName());
	}

}
