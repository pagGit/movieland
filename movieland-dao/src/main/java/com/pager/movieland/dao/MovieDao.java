package com.pager.movieland.dao;

import com.pager.movieland.common.QueryParams;
import com.pager.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getAll(QueryParams queryParams);

    List<Movie> getByGenre(int genreId);

    List<Movie> getByGenre(int genreId, QueryParams queryParams);

    List<Movie> getById(int movieId);
}
