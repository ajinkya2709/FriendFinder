package com.friend.finder.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.friend.finder.service.MatchService;
import com.friend.finder.vo.UserTagsVO;

public class MatchServiceImpl implements MatchService {

	public List<String> getMatchingIds(String Id, Map<String,List<String>> hm) {
		Set main_user=new HashSet(hm.get(Id));
		List<String> result=new ArrayList<String>();
		MinHashServiceImpl<String> minHash; 
		for(Map.Entry<String, List<String>> element:hm.entrySet())
		{
			if(element.getKey().equals(Id))
				continue;
			Set user=new HashSet(element.getValue());
			minHash=new MinHashServiceImpl<String>(main_user.size() + user.size());
			if(minHash.similarity(main_user, user)>0.4)
			{
				result.add(element.getKey());
			}
		}
		return result;
	}

}
