package com.pager.movieland.dao.jdbc;

import com.pager.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JdbcGenreDaoTest {

    @Autowired
    private JdbcGenreDao jdbcGenreDao;

    @Test
    public void testGetAll() {

        List<Genre> expectedGenres = new ArrayList<>();
        Genre firstGenre = new Genre();
        firstGenre.setId(1);
        firstGenre.setName("драма");
        expectedGenres.add(firstGenre);
        Genre secondGenre = new Genre();
        secondGenre.setId(2);
        secondGenre.setName("криминал");
        expectedGenres.add(secondGenre);

        List<Genre> actualMovies = jdbcGenreDao.getAll();
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
