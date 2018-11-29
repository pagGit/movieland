package com.pager.movieland.service;

import com.pager.movieland.common.QueryParams;
import com.pager.movieland.dao.MovieDao;
import com.pager.movieland.entity.Movie;
import com.pager.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {

    private MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getAll(QueryParams queryParams) {
        return movieDao.getAll(queryParams);
    }

    @Override
    public List<Movie> getByGenre(int genreId) {
        return movieDao.getByGenre(genreId);
    }

    @Override
    public List<Movie> getByGenre(int genreId, QueryParams queryParams) {
        return movieDao.getByGenre(genreId, queryParams);
    }

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
}
