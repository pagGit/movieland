package com.pager.movieland.dao.jdbc.mapper;


import com.pager.movieland.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        int id = resultSet.getInt("user_id");
        String nickName = resultSet.getString("nick_name");
        User user = new User(id, nickName);

        return user;
    }
}
