package com.pager.movieland.dao.jdbc;

import com.pager.movieland.dao.GenreDao;
import com.pager.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.pager.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private static final String GET_GENRE_ALL_SQL = "select g.genre_id, g.genre_name from genre g";
    private static final String GET_GENRE_BY_MOVIE_ID_SQL = "select mg.genre_id, g.genre_name from movie_genre mg, genre g where mg.genre_id = g.genre_id and mg.movie_id = ?";
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private final Logger loger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = jdbcTemplate.query(GET_GENRE_ALL_SQL, GENRE_ROW_MAPPER);

        loger.debug("Genres {}", genres);

        return genres;
    }

    @Override
    public List<Genre> getByMovieId(int movieId) {
        List<Genre> genres = jdbcTemplate.query(GET_GENRE_BY_MOVIE_ID_SQL, GENRE_ROW_MAPPER, movieId);

        loger.debug("Genres by movieId [movieId = {}], [genres = {}].", movieId, genres);

        return genres;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
