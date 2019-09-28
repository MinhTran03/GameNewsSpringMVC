package com.springmvc.dao;

import java.util.List;
import com.springmvc.models.*;

public interface TagDAO {

	public List<Tag> getByPostId(int postId);
	
}
