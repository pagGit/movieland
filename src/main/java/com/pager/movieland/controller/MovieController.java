package com.pager.movieland.controller;

import com.pager.movieland.entity.Movie;
import com.pager.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private MovieService movieService;

    @GetMapping("/movie")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/movie/genre/{genreId}")
    public List<Movie> getByGenre(@PathVariable int genreId) {
        return movieService.getByGenre(genreId);
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
