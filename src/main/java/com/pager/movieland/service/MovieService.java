package com.pager.movieland.service;

import com.pager.movieland.entity.Movie;

import java.util.List;
import java.util.Map;

public interface MovieService {
    List<Movie> getAll(Map<String, String> requestParams);
    List<Movie> getByGenre(int genreId, Map<String, String> requestParams);
}
