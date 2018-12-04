package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Review;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReviewRowMapperTest {
    @Test
    public void testRowMap() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("review_id")).thenReturn(1);
        when(resultSet.getInt("user_id")).thenReturn(2);
        when(resultSet.getString("nick_name")).thenReturn("User nickName");
        when(resultSet.getString("text")).thenReturn("Review text.");

        ReviewRowMapper reviewRowMapper = new ReviewRowMapper();
        Review actualReview = reviewRowMapper.mapRow(resultSet, 0);

        assertEquals(1, actualReview.getId());
        assertEquals(2, actualReview.getUser().getId());
        assertEquals("User nickName", actualReview.getUser().getNickName());
        assertEquals("Review text.", actualReview.getText());
    }
}
