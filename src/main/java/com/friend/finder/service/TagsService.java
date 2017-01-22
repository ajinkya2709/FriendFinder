package com.friend.finder.service;

import java.util.List;
import java.util.Map;

import com.friend.finder.vo.UserTagsVO;

public interface TagsService {
	
	public List<String> getTopTags(UserTagsVO userTagsVO);

	public void saveTopTags(String userId,List<String> topTags);
	
	public Map<String,List<String>> getAllTags();
}
