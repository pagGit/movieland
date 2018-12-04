package com.pager.movieland.service;

import com.pager.movieland.dao.ReviewDao;
import com.pager.movieland.entity.Review;
import com.pager.movieland.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultReviewService implements ReviewService {

    private ReviewDao reviewDao;

    @Override
    public List<Review> getByMovieId(int movieId) {
        List<Review> reviews = reviewDao.getByMovieId(movieId);
        return reviews;
    }

    @Autowired
    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

}
