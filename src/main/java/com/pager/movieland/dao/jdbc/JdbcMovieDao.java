package com.pager.movieland.dao.jdbc;

import com.pager.movieland.dao.MovieDao;
import com.pager.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.pager.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {
    private static final String GET_MOVIE_ALL_SQL = "SELECT m.movie_id id, m.name_ru nameRussian, m.name_orig nameNative, m.release_year yearOfRelease, m.rating, m.price, m.picture_path picturePath FROM movie m";
    public static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = jdbcTemplate.query(GET_MOVIE_ALL_SQL, MOVIE_ROW_MAPPER);

        logger.trace("Movies {}", movies);

        return movies;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
