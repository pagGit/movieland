package com.pager.movieland.service;

import com.pager.movieland.dao.CountryDao;
import com.pager.movieland.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCountryService implements CountryService {

    private CountryDao countryDao;

    @Override
    public List<Country> getByMovieId(int movieId) {
        return countryDao.getByMovieId(movieId);
    }

    @Autowired
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
