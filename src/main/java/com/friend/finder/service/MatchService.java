package com.friend.finder.service;

import java.util.List;
import java.util.Map;

import com.friend.finder.vo.UserTagsVO;

public interface MatchService {
	
	public List<String> getMatchingIds(String Id, Map<String,List<String>> hm);
}
