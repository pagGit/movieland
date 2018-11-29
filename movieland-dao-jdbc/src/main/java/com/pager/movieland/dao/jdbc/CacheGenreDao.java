package com.pager.movieland.dao.jdbc;

import com.pager.movieland.dao.GenreDao;
import com.pager.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class CacheGenreDao implements GenreDao {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private volatile List<Genre> cachedGenres;
    private GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        logger.debug("Get all genres [size = {}]", cachedGenres.size());
        return new ArrayList<Genre>(cachedGenres);
    }

    @Scheduled(initialDelayString = "${scheduler.initialDelay}", fixedDelayString = "${scheduler.fixedDelay}")
    @PostConstruct
    public void refreshGenreCache() {
        cachedGenres = genreDao.getAll();
        logger.debug("Genre cache has been refreshed. [size = {}]", cachedGenres.size());
    }

    @Autowired
    public void setGenreDao(@Qualifier("jdbcGenreDao") GenreDao genreDao) {
        this.genreDao = genreDao;
    }
}
