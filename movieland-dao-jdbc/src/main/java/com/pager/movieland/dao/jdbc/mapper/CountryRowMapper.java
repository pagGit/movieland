package com.pager.movieland.dao.jdbc.mapper;

import com.pager.movieland.entity.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();

        country.setId(resultSet.getInt("country_id"));
        country.setName(resultSet.getString("country_name"));

        return country;
    }
}
