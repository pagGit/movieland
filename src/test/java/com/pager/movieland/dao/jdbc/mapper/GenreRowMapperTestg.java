package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Genre;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreRowMapperTestg {
    @Test
    public void testRowMap() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("драма");

        GenreRowMapper genreMapper = new GenreRowMapper();
        Genre actualGenre = genreMapper.mapRow(resultSet, 0);

        assertEquals(1, actualGenre.getId());
        assertEquals("драма", actualGenre.getName());
    }
}
