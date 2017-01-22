package com.friend.finder.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.friend.finder.service.TagsService;
import com.friend.finder.vo.UserTagsVO;

@Service
public class TagsServiceImpl implements TagsService{

	public List<String> getTopTags(UserTagsVO userTagsVO) {
		if(userTagsVO == null || userTagsVO.getTags() == null)
			return null;
		
		Map<String, Integer> frequencyOfTag = new HashMap<String, Integer>();
		List<String> tags = userTagsVO.getTags();
		for(int i=0;i<tags.size();i++){
			String tag = tags.get(i);
			if(!frequencyOfTag.containsKey(tag)){
				frequencyOfTag.put(tag, 0);
			}
			frequencyOfTag.put(tag, frequencyOfTag.get(tag)+1);
		}
		
		Map<Integer,List<String>> tagsAtFrequency = new TreeMap<Integer,List<String>>(Collections.reverseOrder());
		for(String tag : frequencyOfTag.keySet()){
			if(!tagsAtFrequency.containsKey(frequencyOfTag.get(tag)))
				tagsAtFrequency.put(frequencyOfTag.get(tag), new ArrayList<String>());
			tagsAtFrequency.get(frequencyOfTag.get(tag)).add(tag);
		}
		List<String> result = new ArrayList<String>();
		for(Integer freq :tagsAtFrequency.keySet()){
			result.addAll(tagsAtFrequency.get(freq));
			if(result.size()>30)
				break;
		}
		
		return result;
		
	}

	public void saveTopTags(String userId, List<String> topTags) {

		
	}

	public Map<String, List<String>> getAllTags() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
