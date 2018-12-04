package com.pager.movieland.dao.jdbc;

import com.pager.movieland.entity.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/jdbc-dao-context.xml", "classpath:/jdbc-dao-test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JdbcMovieDaoTest {

    private JdbcMovieDao jdbcMovieDao;

    @Test
    public void testGetAll() {
        List<Movie> expectedMovies = new ArrayList<>();
        Movie firstMovie = new Movie();
        firstMovie.setId(1);
        firstMovie.setNameRussian("Побег из Шоушенка");
        firstMovie.setNameNative("The Shawshank Redemption");
        firstMovie.setYearOfRelease(1994);
        firstMovie.setDescription("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.");
        firstMovie.setRating(8.9);
        firstMovie.setPrice(123.45);
        firstMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovies.add(firstMovie);

        Movie secondMiovie = new Movie();
        secondMiovie.setId(2);
        secondMiovie.setNameRussian("Зеленая миля");
        secondMiovie.setNameNative("The Green Mile");
        secondMiovie.setYearOfRelease(1999);
        secondMiovie.setDescription("Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.");
        secondMiovie.setRating(8.9);
        secondMiovie.setPrice(134.67);
        secondMiovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovies.add(secondMiovie);

        List<Movie> actualMovies = jdbcMovieDao.getAll();
        assertEquals(2, actualMovies.size());

        Movie actual1 = actualMovies.get(0);
        Movie expected1 = expectedMovies.get(0);

        assertEquals(expected1.getId(), actual1.getId());
        assertEquals(expected1.getNameRussian(), actual1.getNameRussian());
        assertEquals(expected1.getNameNative(), actual1.getNameNative());
        assertEquals(expected1.getYearOfRelease(), actual1.getYearOfRelease());
        assertEquals(expected1.getDescription(), actual1.getDescription());
        assertEquals(expected1.getRating(), actual1.getRating(), 0d);
        assertEquals(expected1.getPrice(), actual1.getPrice(), 0d);
        assertEquals(expected1.getPicturePath(), actual1.getPicturePath());

        Movie actual2 = actualMovies.get(1);
        Movie expected2 = expectedMovies.get(1);

        assertEquals(expected2.getId(), actual2.getId());
        assertEquals(expected2.getNameRussian(), actual2.getNameRussian());
        assertEquals(expected2.getNameNative(), actual2.getNameNative());
        assertEquals(expected2.getYearOfRelease(), actual2.getYearOfRelease());
        assertEquals(expected2.getDescription(), actual2.getDescription());
        assertEquals(expected2.getRating(), actual2.getRating(), 0d);
        assertEquals(expected2.getPrice(), actual2.getPrice(), 0d);
        assertEquals(expected2.getPicturePath(), actual2.getPicturePath());

    }

    @Test
    public void testGetByGenre() {
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

        List<Movie> actualMovies = jdbcMovieDao.getByGenre(1);
        assertEquals(2, actualMovies.size());

        Movie actual1 = actualMovies.get(0);
        Movie expected1 = expectedMovies.get(0);

        assertEquals(expected1.getId(), actual1.getId());
        assertEquals(expected1.getNameRussian(), actual1.getNameRussian());
        assertEquals(expected1.getNameNative(), actual1.getNameNative());
        assertEquals(expected1.getYearOfRelease(), actual1.getYearOfRelease());
        assertEquals(expected1.getRating(), actual1.getRating(), 0d);
        assertEquals(expected1.getPrice(), actual1.getPrice(), 0d);
        assertEquals(expected1.getPicturePath(), actual1.getPicturePath());

        Movie actual2 = actualMovies.get(1);
        Movie expected2 = expectedMovies.get(1);

        assertEquals(expected2.getId(), actual2.getId());
        assertEquals(expected2.getNameRussian(), actual2.getNameRussian());
        assertEquals(expected2.getNameNative(), actual2.getNameNative());
        assertEquals(expected2.getYearOfRelease(), actual2.getYearOfRelease());
        assertEquals(expected2.getRating(), actual2.getRating(), 0d);
        assertEquals(expected2.getPrice(), actual2.getPrice(), 0d);
        assertEquals(expected2.getPicturePath(), actual2.getPicturePath());
    }

    @Autowired
    public void setJdbcMovieDao(JdbcMovieDao jdbcMovieDao) {
        this.jdbcMovieDao = jdbcMovieDao;
    }


}
