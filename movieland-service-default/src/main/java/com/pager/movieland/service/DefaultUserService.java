package com.pager.movieland.service;

import com.pager.movieland.dao.UserDao;
import com.pager.movieland.entity.Review;
import com.pager.movieland.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private UserDao userDao;

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public void enrich(List<Review> reviews) {
        if (reviews != null) {
            reviews.forEach(review -> enrich(review.getUser())
            );
        }
    }
        @Override
        public void enrich (User user){
            if (user != null && (user.getNickName() == null || user.getNickName().isEmpty())) {
                int userId = user.getId();
                String nickName = getById(userId).getNickName();
                user.setNickName(nickName);
            }
        }

        @Autowired
        public void setUserDao (UserDao userDao){
            this.userDao = userDao;
        }

    }
