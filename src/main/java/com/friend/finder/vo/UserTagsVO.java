package com.friend.finder.vo;

import java.util.List;

public class UserTagsVO {

	private String userId;
	private List<String> tags;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
