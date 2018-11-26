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
import java.util.Map;

@Repository
public class JdbcMovieDao implements MovieDao {
    private static final String GET_MOVIE_ALL_SQL = "SELECT m.movie_id id, m.name_ru nameRussian, m.name_orig nameNative, m.release_year yearOfRelease, m.rating, m.price, m.picture_path picturePath FROM movie m";
    private static final String GET_MOVIE_BY_GENRE_ID_SQL = "SELECT m.movie_id id, m.name_ru nameRussian, m.name_orig nameNative, m.release_year yearOfRelease, m.rating, m.price, m.picture_path picturePath FROM movie m, movie_genre mg where m.movie_id = mg.movie_id and mg.genre_id = ?";
    public static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll(Map<String, String> requestParams) {
        String query = QueryBuilder.build(GET_MOVIE_ALL_SQL,requestParams);
        logger.trace("New query {}", query);
        List<Movie> movies = jdbcTemplate.query(GET_MOVIE_ALL_SQL, MOVIE_ROW_MAPPER);

        logger.trace("Movies {}", movies);

        return movies;
    }

    @Override
    public List<Movie> getByGenre(int genreId, Map<String, String> requestParams) {
        List<Movie> movies = jdbcTemplate.query(GET_MOVIE_BY_GENRE_ID_SQL, MOVIE_ROW_MAPPER, genreId);

        logger.trace("Movies by genre [GenreId = {}], [Movies: {}]", genreId, movies);

        return movies;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
