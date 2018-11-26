package com.pager.movieland.service.Impl;

import com.pager.movieland.dao.jdbc.JdbcGenreDao;
import com.pager.movieland.entity.Genre;
import org.junit.Test;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultGenreServiceTest {
    @Test
    public void getAll() {
        JdbcGenreDao jdbcGenreDao = mock(JdbcGenreDao.class);

        List<Genre> expectedGenres = new ArrayList<>();
        Genre firstGenre = new Genre(1, "драма");
        expectedGenres.add(firstGenre);
        Genre secondGenre = new Genre(2, "криминал");
        expectedGenres.add(secondGenre);

        DefaultGenreService genreService = new DefaultGenreService();
        genreService.setGenreDao(jdbcGenreDao);

        when(jdbcGenreDao.getAll()).thenReturn(expectedGenres);

        List<Genre> actualGenres = genreService.getAll();

        assertEquals(2, actualGenres.size());

        Genre actual1 = actualGenres.get(0);
        Genre expected1 = expectedGenres.get(0);
        assertEquals(expected1.getId(), actual1.getId());
        assertEquals(expected1.getName(), actual1.getName());

        Genre actual2 = actualGenres.get(1);
        Genre expected2 = expectedGenres.get(1);
        assertEquals(expected2.getId(), actual2.getId());
        assertEquals(expected2.getName(), actual2.getName());

    }
}

