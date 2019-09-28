package com.springmvc.models;

import com.springmvc.entities.*;

public class Tag {

	private int tagId;
	
	private String name;

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void entity2model(TagEntity entity) {
		this.setTagId(entity.getTag_id());
		this.setName(entity.getName());
	}
}
