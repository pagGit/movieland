package com.pager.movieland.service;

import com.pager.movieland.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getByMovieId(int movieId);
}
