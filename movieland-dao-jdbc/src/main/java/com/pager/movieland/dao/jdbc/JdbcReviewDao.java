package com.pager.movieland.dao.jdbc;

import com.pager.movieland.dao.ReviewDao;
import com.pager.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.pager.movieland.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewDao implements ReviewDao {
    private static final String GET_REVIEWS_BY_MOVIE_ID = "select mr.review_id, mr.user_id, u.nick_name, mr.text from movie_review mr, users u where mr.user_id = u.user_id and mr.movie_id = ?";
    private static final ReviewRowMapper REVIEW_ROW_MAPPER = new ReviewRowMapper();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Review> getByMovieId(int movieId) {

        List<Review> reviews = jdbcTemplate.query(GET_REVIEWS_BY_MOVIE_ID, REVIEW_ROW_MAPPER, movieId);

        logger.trace("Reviews by movieId [movieId = {}], [Movies: {}]", movieId, reviews);

        return reviews;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
