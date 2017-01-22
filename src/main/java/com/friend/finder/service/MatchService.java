package com.friend.finder.service;

import java.util.List;

import com.friend.finder.vo.UserTagsVO;

public interface MatchService {
	
	public List<String> getMatchingIds(UserTagsVO userTagsVO, List<String> tags);

}
