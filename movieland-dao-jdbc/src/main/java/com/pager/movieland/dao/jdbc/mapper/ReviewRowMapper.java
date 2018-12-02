package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Review;
import com.pager.movieland.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        Review review = new Review();
        review.setId(resultSet.getInt("review_id"));
        review.setUser(new User(resultSet.getInt("user_id")));
        review.setText(resultSet.getString("text"));
        return review;
    }
}
