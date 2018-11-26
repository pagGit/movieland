package com.pager.movieland.dao;

import com.pager.movieland.entity.Movie;

import java.util.List;
import java.util.Map;

public interface MovieDao {
    List<Movie> getAll(Map<String, String> requestParams);
    List<Movie> getByGenre(int genreId, Map<String, String> requestParams);
}
