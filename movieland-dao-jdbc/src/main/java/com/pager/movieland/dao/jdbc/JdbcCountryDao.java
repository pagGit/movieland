package com.pager.movieland.dao.jdbc;

import com.pager.movieland.dao.CountryDao;
import com.pager.movieland.dao.jdbc.mapper.CountryRowMapper;
import com.pager.movieland.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCountryDao implements CountryDao {
    private static final String GET_COUNTRIES_BY_MOVIE_ID_SQL = "select c.country_id, c.country_name from movie_country mc, country c where mc.country_id = c.country_id and mc.movie_id = ? order by c.country_name";
    private static final CountryRowMapper COUNRTY_ROW_MAPPER = new CountryRowMapper();
    private final Logger loger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> getByMovieId(int movieId) {
        return jdbcTemplate.query(GET_COUNTRIES_BY_MOVIE_ID_SQL, COUNRTY_ROW_MAPPER, movieId);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
