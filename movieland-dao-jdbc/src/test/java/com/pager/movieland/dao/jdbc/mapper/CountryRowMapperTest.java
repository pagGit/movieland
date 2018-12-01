package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Country;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryRowMapperTest {
    @Test
    public void testRowMap() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("country_id")).thenReturn(1);
        when(resultSet.getString("country_name")).thenReturn("Великобритания");

        CountryRowMapper countryMapper = new CountryRowMapper();
        Country actualCountry = countryMapper.mapRow(resultSet, 0);

        assertEquals(1, actualCountry.getId());
        assertEquals("Великобритания", actualCountry.getName());
    }
}
