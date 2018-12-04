package com.pager.movieland.dao.jdbc;

import com.pager.movieland.dao.UserDao;
import com.pager.movieland.dao.jdbc.mapper.UserRowMapper;
import com.pager.movieland.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDao implements UserDao {
    private static final String GET_USER_BY_ID = "select u.user_id, u.nick_name from users u where user_id = ?";
    private static final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Override
    public User getById(int userId) {
        User user = jdbcTemplate.queryForObject(GET_USER_BY_ID, USER_ROW_MAPPER, userId);

        logger.trace("User [userId = {}], [User: {}]", userId, user);

        return user;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
