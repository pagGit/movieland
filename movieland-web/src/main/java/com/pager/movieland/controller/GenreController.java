package com.pager.movieland.controller;

import com.pager.movieland.entity.Genre;
import com.pager.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private GenreService genreService;

    @GetMapping("/genre")
    public List<Genre> getAll() {
        return genreService.getAll();

    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }
}
