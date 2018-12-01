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
    private UserService userService;

    @Override
    public List<Review> getByMovieId(int movieId) {
        List<Review> reviews = reviewDao.getByMovieId(movieId);
        userService.enrich(reviews);
        return reviews;
    }

//    @Override
//    public void enrich(List<Review> reviews) {
//        if (reviews != null) {
//            reviews.forEach(review -> {
//                User user = review.getUser();
//                userService.enrich(user);
//                    }
//// userService.enrich(review.getUser())
//            );
//        }
//    }

    @Autowired
    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
