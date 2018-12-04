package com.pager.movieland.service;

import com.pager.movieland.dao.ReviewDao;
import com.pager.movieland.entity.Review;
import com.pager.movieland.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class DefaultReviewServiceTest {

    @Test
    public void testGetByMovieId() {
        ReviewDao mockReviewDao = mock(ReviewDao.class);
        DefaultReviewService defaultReviewService = new DefaultReviewService();
        defaultReviewService.setReviewDao(mockReviewDao);

        Review review = new Review();
        User user = new User(2, "User nickName");
        review.setId(1);
        review.setUser(user);
        review.setText("Review text.");
        List<Review> expectedReviews = new ArrayList<>();
        expectedReviews.add(review);

        when(mockReviewDao.getByMovieId(1)).thenReturn(expectedReviews);

        List<Review> actualReviews = defaultReviewService.getByMovieId(1);

        assertEquals(Arrays.asList(review), actualReviews);
        verify(mockReviewDao, times(1)).getByMovieId(1);
    }

}
