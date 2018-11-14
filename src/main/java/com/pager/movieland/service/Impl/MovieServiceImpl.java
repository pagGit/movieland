package com.pager.movieland.service.Impl;

import com.pager.movieland.dao.MovieDao;
import com.pager.movieland.entity.Movie;
import com.pager.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

}
