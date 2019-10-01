package com.springmvc.dao;

import java.util.List;
import com.springmvc.models.*;

public interface TagDAO extends DAOBase<Tag> {

	public List<Tag> getByPostId(int postId);
	
}
