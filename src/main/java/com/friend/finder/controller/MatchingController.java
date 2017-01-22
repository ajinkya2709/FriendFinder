package com.friend.finder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.friend.finder.service.MatchService;
import com.friend.finder.service.TagsService;
import com.friend.finder.vo.UserTagsVO;

@Controller
public class MatchingController {
	
	@Autowired
	MatchService matchService;
	
	@Autowired
	TagsService tagsService;
	
	@PostMapping(value="/findMatch")
	public List<String> getMatchingIds(@RequestBody UserTagsVO userTagsVO){
		List<String> topTags = tagsService.getTopTags(userTagsVO);
		tagsService.saveTopTags(userTagsVO.getUserId(), topTags);
		Map<String,List<String>> data = tagsService.getAllTags();
		List<String> result=null ;
		return result;
	}
	
}
