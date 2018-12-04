package com.pager.movieland.service;

import com.pager.movieland.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getByMovieId(int movieId);
}
