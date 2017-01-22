package com.friend.finder.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friend.finder.dao.TagsDAO;
import com.friend.finder.domain.UserInfo;
import com.friend.finder.service.TagsService;
import com.friend.finder.vo.UserTagsVO;

@Service
public class TagsServiceImpl implements TagsService{
	
	@Autowired
	TagsDAO tagsDAO;

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
		String tags = getCommaSeparatedTags(topTags);
		tagsDAO.saveTags(userId, tags);
	}

	public Map<String, List<String>> getAllTags() {
		List<UserInfo> users = tagsDAO.getAllTags();
		return getTagLists(users);
	}
	
	private String getCommaSeparatedTags(List<String> tagList){
		StringBuffer result = new StringBuffer();
		if(tagList == null || tagList.size() == 0)
			return result.toString();
		for(String tag : tagList){
			result.append(tag+",");
		}
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}
	
	private Map<String, List<String>> getTagLists(List<UserInfo> users){
		Map<String,List<String>> result = new HashMap<String, List<String>>();
		if(users == null || users.size()==0)
			return result;
		
		for(UserInfo user:users){
			List<String> tagList = Arrays.asList(user.getTags().split(","));
			result.put(user.getUserId(), tagList);
		}
		
		return result;
	}
	

}
