package com.friend.finder.dao;

import java.util.List;

import com.friend.finder.domain.UserInfo;

public interface TagsDAO {

	public void saveTags(String userId, String tags);

	public List<UserInfo> getAllTags();

}
