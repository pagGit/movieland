package com.pager.movieland.service;

import com.pager.movieland.common.QueryParams;
import com.pager.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getAll(QueryParams queryParams);

    List<Movie> getByGenre(int genreId);

    List<Movie> getByGenre(int genreId, QueryParams queryParams);

    List<Movie> getById(int movieId);

    void enrich(List<Movie> movies);
}
