package com.pager.movieland.dao;

import com.pager.movieland.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getByMovieId(int movieId);
}
