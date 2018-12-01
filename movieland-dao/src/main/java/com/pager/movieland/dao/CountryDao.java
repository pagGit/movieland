package com.pager.movieland.dao;

import com.pager.movieland.entity.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getByMovieId(int movieId);
}
