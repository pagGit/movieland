package com.pager.movieland.service.Impl;

import com.pager.movieland.dao.jdbc.JdbcMovieDao;
import com.pager.movieland.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultMovieServiceTest {
    @Test
    public void getAll() {
        JdbcMovieDao jdbcMovieDao = mock(JdbcMovieDao.class);

        List<Movie> expectedMovies = new ArrayList<>();
        Movie firstMovie = new Movie();
        firstMovie.setId(1);
        firstMovie.setNameRussian("Побег из Шоушенка");
        firstMovie.setNameNative("The Shawshank Redemption");
        firstMovie.setYearOfRelease(1994);
        firstMovie.setRating(8.9);
        firstMovie.setPrice(123.45);
        firstMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovies.add(firstMovie);

        Movie secondMiovie = new Movie();
        secondMiovie.setId(2);
        secondMiovie.setNameRussian("Зеленая миля");
        secondMiovie.setNameNative("The Green Mile");
        secondMiovie.setYearOfRelease(1999);
        secondMiovie.setRating(8.9);
        secondMiovie.setPrice(134.67);
        secondMiovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovies.add(secondMiovie);

        DefaultMovieService movieService = new DefaultMovieService();
        movieService.setMovieDao(jdbcMovieDao);

        when(jdbcMovieDao.getAll(null)).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getAll(null);

        assertEquals(2, actualMovies.size());

        Movie actual1 = actualMovies.get(0);
        Movie expected1 = expectedMovies.get(0);
        assertEquals(expected1.getId(),actual1.getId());
        assertEquals(expected1.getNameRussian(),actual1.getNameRussian());
        assertEquals(expected1.getNameNative(),actual1.getNameNative());
        assertEquals(expected1.getYearOfRelease(),actual1.getYearOfRelease());
        assertEquals(expected1.getRating(),actual1.getRating(),0d);
        assertEquals(expected1.getPrice(),actual1.getPrice(),0d);
        assertEquals(expected1.getPicturePath(),actual1.getPicturePath());

        Movie actual2 = actualMovies.get(1);
        Movie expected2 = expectedMovies.get(1);
        assertEquals(expected2.getId(),actual2.getId());
        assertEquals(expected2.getNameRussian(),actual2.getNameRussian());
        assertEquals(expected2.getNameNative(),actual2.getNameNative());
        assertEquals(expected2.getYearOfRelease(),actual2.getYearOfRelease());
        assertEquals(expected2.getRating(),actual2.getRating(),0d);
        assertEquals(expected2.getPrice(),actual2.getPrice(),0d);
        assertEquals(expected2.getPicturePath(),actual2.getPicturePath());
    }

    @Test
    public void testGetByGenre() {
        JdbcMovieDao jdbcMovieDao = mock(JdbcMovieDao.class);

        List<Movie> expectedMovies = new ArrayList<>();
        Movie firstMovie = new Movie();
        firstMovie.setId(1);
        firstMovie.setNameRussian("Побег из Шоушенка");
        firstMovie.setNameNative("The Shawshank Redemption");
        firstMovie.setYearOfRelease(1994);
        firstMovie.setRating(8.9);
        firstMovie.setPrice(123.45);
        firstMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovies.add(firstMovie);

        Movie secondMiovie = new Movie();
        secondMiovie.setId(2);
        secondMiovie.setNameRussian("Зеленая миля");
        secondMiovie.setNameNative("The Green Mile");
        secondMiovie.setYearOfRelease(1999);
        secondMiovie.setRating(8.9);
        secondMiovie.setPrice(134.67);
        secondMiovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovies.add(secondMiovie);

        DefaultMovieService movieService = new DefaultMovieService();
        movieService.setMovieDao(jdbcMovieDao);

        when(jdbcMovieDao.getByGenre(1, null)).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getByGenre(1, null);

        assertEquals(2, actualMovies.size());

        Movie actual1 = actualMovies.get(0);
        Movie expected1 = expectedMovies.get(0);
        assertEquals(expected1.getId(),actual1.getId());
        assertEquals(expected1.getNameRussian(),actual1.getNameRussian());
        assertEquals(expected1.getNameNative(),actual1.getNameNative());
        assertEquals(expected1.getYearOfRelease(),actual1.getYearOfRelease());
        assertEquals(expected1.getRating(),actual1.getRating(),0d);
        assertEquals(expected1.getPrice(),actual1.getPrice(),0d);
        assertEquals(expected1.getPicturePath(),actual1.getPicturePath());

        Movie actual2 = actualMovies.get(1);
        Movie expected2 = expectedMovies.get(1);
        assertEquals(expected2.getId(),actual2.getId());
        assertEquals(expected2.getNameRussian(),actual2.getNameRussian());
        assertEquals(expected2.getNameNative(),actual2.getNameNative());
        assertEquals(expected2.getYearOfRelease(),actual2.getYearOfRelease());
        assertEquals(expected2.getRating(),actual2.getRating(),0d);
        assertEquals(expected2.getPrice(),actual2.getPrice(),0d);
        assertEquals(expected2.getPicturePath(),actual2.getPicturePath());
    }
}
