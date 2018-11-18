package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Movie;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {
    @Test
    public void testRowMap() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("nameRussian")).thenReturn("Побег из Шоушенка");
        when(resultSet.getString("nameNative")).thenReturn("The Shawshank Redemption");
        when(resultSet.getInt("yearOfRelease")).thenReturn(1994);
        when(resultSet.getDouble("rating")).thenReturn(8.9);
        when(resultSet.getDouble("price")).thenReturn(123.45);
        when(resultSet.getString("picturePath")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");

        MovieRowMapper movieMapper = new MovieRowMapper();
        Movie actualMovie = movieMapper.mapRow(resultSet, 0);

        assertEquals(1, actualMovie.getId());
        assertEquals("Побег из Шоушенка", actualMovie.getNameRussian());
        assertEquals("The Shawshank Redemption", actualMovie.getNameNative());
        assertEquals(1994, actualMovie.getYearOfRelease());
        assertEquals(8.9, actualMovie.getRating(), 0d);
        assertEquals(123.45, actualMovie.getPrice(), 0d);
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg", actualMovie.getPicturePath());
    }
}
