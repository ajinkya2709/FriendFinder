package com.friend.finder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.friend.finder.service.MatchService;
import com.friend.finder.vo.UserTagsVO;

@Controller
public class MatchingController {
	
	@Autowired
	MatchService matchService;
	
	@PostMapping(value="/")
	public List<String> getMatchingIds(@RequestBody UserTagsVO userTagsVO){
		
		return null;
	}
	
}
