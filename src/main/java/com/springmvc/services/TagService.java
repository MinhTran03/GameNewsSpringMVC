package com.springmvc.services;

import java.util.List;
import com.springmvc.models.Tag;

public interface TagService extends ServiceBase<Tag> {
	public List<Tag> getByPostId(int postId);
}
