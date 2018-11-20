package com.pager.movieland.service.Impl;

import com.pager.movieland.dao.GenreDao;
import com.pager.movieland.entity.Genre;
import com.pager.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {

    private GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    @Autowired
    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }
}
