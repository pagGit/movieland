package com.pager.movieland.service;

import com.pager.movieland.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();

    List<Genre> getByMovieId(int movieId);
}
