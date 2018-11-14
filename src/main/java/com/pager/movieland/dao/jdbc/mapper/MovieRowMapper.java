package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("Id"));
        movie.setNameRussian(resultSet.getString("nameRussian"));
        movie.setNameNative(resultSet.getString("nameNative"));
        movie.setYearOfRelease(resultSet.getInt("yearOfRelease"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPicturePath(resultSet.getString("picturePath"));
        return movie;
    }
}
