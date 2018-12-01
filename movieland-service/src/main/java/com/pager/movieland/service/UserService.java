package com.pager.movieland.service;

import com.pager.movieland.entity.Review;
import com.pager.movieland.entity.User;

import java.util.List;

public interface UserService {
    User getById(int userId);

    void enrich(List<Review> reviews);

    void enrich(User user);
}
