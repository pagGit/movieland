package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("genre_id");
        String name = resultSet.getString("genre_name");
        Genre genre = new Genre(id, name);

        return genre;
    }
}
