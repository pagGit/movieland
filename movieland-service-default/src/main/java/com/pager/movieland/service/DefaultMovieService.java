package com.pager.movieland.service;

import com.pager.movieland.common.QueryParams;
import com.pager.movieland.dao.MovieDao;
import com.pager.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {

    private MovieDao movieDao;
    private CountryService countryService;
    private GenreService genreService;
    private ReviewService reviewService;

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

    @Override
    public List<Movie> getById(int movieId) {

        List<Movie> movies = movieDao.getById(movieId);
        enrich(movies);

        return movies;
    }

    @Override
    public void enrich(List<Movie> movies) {
        movies.forEach(movie -> {
            int movieId = movie.getId();
            movie.setCountries(countryService.getByMovieId(movieId));
            movie.setGenres(genreService.getByMovieId(movieId));
            movie.setReviews(reviewService.getByMovieId(movieId));
        });
    }

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


}
