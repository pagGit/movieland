package com.pager.movieland.service.Impl;

import com.pager.movieland.dao.MovieDao;
import com.pager.movieland.entity.Movie;
import com.pager.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DefaultMovieService implements MovieService {

    private MovieDao movieDao;

    @Override
    public List<Movie> getAll(Map<String, String> requestParams) {
        return movieDao.getAll(requestParams);
    }

    @Override
    public List<Movie> getByGenre(int genreId, Map<String, String> requestParams) {
        return movieDao.getByGenre(genreId, requestParams);
    }

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
}
