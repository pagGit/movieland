package com.pager.movieland.service;

import com.pager.movieland.dao.jdbc.JdbcCountryDao;
import com.pager.movieland.entity.Country;
import com.pager.movieland.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultCountryServiceTest {
    @Test
    public void testGetByMovieId() {
        JdbcCountryDao jdbcCountryDao = mock(JdbcCountryDao.class);

        List<Country> expectedCountries = new ArrayList<>();
        Country firstCountry = new Country(1, "Великобритания");
        Country secondCountry = new Country(2, "Италия");
        expectedCountries.add(firstCountry);
        expectedCountries.add(secondCountry);

        DefaultCountryService countryService = new DefaultCountryService();
        countryService.setCountryDao(jdbcCountryDao);

        when(jdbcCountryDao.getByMovieId(1)).thenReturn(expectedCountries);

        List<Country> actualCountries = countryService.getByMovieId(1);

        assertEquals(2, actualCountries.size());
        assertEquals(expectedCountries, actualCountries);
    }
}
