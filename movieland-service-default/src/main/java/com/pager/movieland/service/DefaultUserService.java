package com.pager.movieland.service;

import com.pager.movieland.dao.UserDao;
import com.pager.movieland.entity.Review;
import com.pager.movieland.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private UserDao userDao;

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public User getByEmail(String email, String password) {
        Optional<User> optionalUser = Optional.ofNullable(userDao.getByEmail(email))
                .filter(userChk -> userChk.getPassword().equals(password));
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            logger.info("Incorrect email or password for user {}!", email);
            return null;
        }
    }

    @Override
    public void enrich(List<Review> reviews) {
        if (reviews != null) {
            reviews.forEach(review -> enrich(review.getUser())
            );
        }
    }

    @Override
    public void enrich(User user) {
        if (user != null && (user.getNickName() == null || user.getNickName().isEmpty())) {
            int userId = user.getId();
            String nickName = getById(userId).getNickName();
            user.setNickName(nickName);
        }
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
