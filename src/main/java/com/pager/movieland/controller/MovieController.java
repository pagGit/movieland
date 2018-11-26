package com.pager.movieland.controller;

import com.pager.movieland.entity.Movie;
import com.pager.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private MovieService movieService;

    @GetMapping("/movie")
    public List<Movie> getAll(@RequestParam Map<String, String> requestParams) {

        logger.debug("[requestParams = {}]", requestParams);

        return movieService.getAll(requestParams);
    }

    @GetMapping("/movie/genre/{genreId}")
    public List<Movie> getByGenre(@PathVariable int genreId, @RequestParam Map<String, String> requestParams) {

        logger.debug("[requestParams = {}]", requestParams);

        return movieService.getByGenre(genreId, requestParams);
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
