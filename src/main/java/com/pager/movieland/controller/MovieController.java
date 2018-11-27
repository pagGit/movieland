package com.pager.movieland.controller;

import com.pager.movieland.common.QueryParams;
import com.pager.movieland.common.RequestParamParser;
import com.pager.movieland.entity.Movie;
import com.pager.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

import static com.pager.movieland.common.RequestParamParser.getQueryParams;

@RestController
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private MovieService movieService;

    @GetMapping("/movie")
    public List<Movie> getAll(@RequestParam LinkedHashMap<String, String> requestParams) {

        logger.debug("[requestParams = {}]", requestParams);

        if (!requestParams.isEmpty() && RequestParamParser.containOrderParam(requestParams)) {
            return movieService.getAll(RequestParamParser.getQueryParams(requestParams));
        }
        return movieService.getAll();
    }

    @GetMapping("/movie/genre/{genreId}")
    public List<Movie> getByGenre(@PathVariable int genreId, @RequestParam LinkedHashMap<String, String> requestParams) {

        logger.debug("[requestParams = {}]", requestParams);

        if (RequestParamParser.containOrderParam(requestParams)) {
            QueryParams queryParams = getQueryParams(requestParams);
            return movieService.getByGenre(genreId, queryParams);
        }

        return movieService.getByGenre(genreId);
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
