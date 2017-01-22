package com.friend.finder.dao.impl;

import static com.friend.finder.constants.Queries.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.friend.finder.dao.TagsDAO;
import com.friend.finder.domain.UserInfo;

@Component
public class TagsDAOImpl extends JdbcDaoSupport implements TagsDAO {

	public TagsDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public void saveTags(String userId, String tags) {
		System.out.println("Inserting new user Tags");
		getJdbcTemplate().update(ADD_TAGS, userId, tags);
	}

	public List<UserInfo> getAllTags() {
		List<UserInfo> result = getJdbcTemplate().query(GET_ALL_USERS,
				new RowMapper<UserInfo>() {

					public UserInfo mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						UserInfo userInfo = new UserInfo();
						userInfo.setUserId(rs.getString("USER_ID"));
						userInfo.setTags(rs.getString("TAGS"));
						return userInfo;
					}

				});
		return result;
	}
}
