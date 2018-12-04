package com.pager.movieland.dao;

import com.pager.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();

    List<Genre> getByMovieId(int movieId);
}
