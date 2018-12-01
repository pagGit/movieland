package com.pager.movieland.dao.jdbc;

import com.pager.movieland.dao.GenreDao;
import com.pager.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/jdbc-dao-context.xml", "classpath:/jdbc-dao-test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CacheGenreDaoTest {

    @Autowired
    @Qualifier("cacheGenreDao")
    private GenreDao cacheGenreDao;

    @Test
    public void testGetAll() {
        List<Genre> expectedGenres = new ArrayList<>();
        Genre firstGenre = new Genre(1, "драма");
        expectedGenres.add(firstGenre);
        Genre secondGenre = new Genre(2, "криминал");
        expectedGenres.add(secondGenre);

        List<Genre> actualMovies = cacheGenreDao.getAll();
        assertEquals(2, actualMovies.size());

        Genre actual1 = actualMovies.get(0);
        Genre expected1 = expectedGenres.get(0);

        assertEquals(expected1.getId(), actual1.getId());
        assertEquals(expected1.getName(), actual1.getName());

        Genre actual2 = actualMovies.get(1);
        Genre expected2 = expectedGenres.get(1);

        assertEquals(expected2.getId(), actual2.getId());
        assertEquals(expected2.getName(), actual2.getName());
    }

    @Test
    public void testGetByMovieId() {
        List<Genre> expectedGenres = new ArrayList<>();
        Genre firstGenre = new Genre(1, "драма");
        expectedGenres.add(firstGenre);
        Genre secondGenre = new Genre(2, "криминал");
        expectedGenres.add(secondGenre);

        List<Genre> actualMovies = cacheGenreDao.getByMovieId(1);
        assertEquals(2, actualMovies.size());

        Genre actual1 = actualMovies.get(0);
        Genre expected1 = expectedGenres.get(0);

        assertEquals(expected1.getId(), actual1.getId());
        assertEquals(expected1.getName(), actual1.getName());

        Genre actual2 = actualMovies.get(1);
        Genre expected2 = expectedGenres.get(1);

        assertEquals(expected2.getId(), actual2.getId());
        assertEquals(expected2.getName(), actual2.getName());
    }
}
