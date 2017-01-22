package com.friend.finder.constants;

public class Queries {
	
	public static final String ADD_TAGS = "insert into user_info (USER_ID, TAGS) values (?,?)";
	
	public static final String GET_ALL_USERS = "select USER_ID,TAGS from user_info ";

}
