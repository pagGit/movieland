package com.pager.movieland.controller;

import com.pager.movieland.dao.MovieDao;
import com.pager.movieland.entity.*;
import com.pager.movieland.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/test-context.xml"})
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MovieControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieDao movieDao;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAll() throws Exception {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease(1993);
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        when(movieService.getAll()).thenReturn(Arrays.asList(movie));

        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1993)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")));

    }

    @Test
    public void testGetByGenre() throws Exception {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease(1993);
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        when(movieService.getByGenre(2)).thenReturn(Arrays.asList(movie));

        mockMvc.perform(get("/movie/genre/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1993)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetById() throws Exception {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease(1993);
        movie.setDescription("Movie description.");
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");
        Country country = new Country(5,"США");
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(country);
        movie.setCountries(countries);
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(new Genre(1, "драма"));
        genres.add(new Genre(2, "криминал"));
        movie.setGenres(genres);
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review();
        review.setId(1);
        review.setUser(new User(2,"darlene.edwards15@example.com"));
        review.setText("Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.");
        reviews.add(review);
        movie.setReviews(reviews);

        when(movieService.getById(1)).thenReturn(movie);
        doNothing().when(movieService).enrich(any(Movie.class));

        mockMvc.perform(get("/movie/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1993)))
                .andExpect(jsonPath("$[0].description.", equalTo("Movie description.")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[0].countries", hasSize(1)))
                .andExpect(jsonPath("$[0].countries[0].id", equalTo(5)))
                .andExpect(jsonPath("$[0].countries[0].name", equalTo("США")))
                .andExpect(jsonPath("$[0].genres", hasSize(2)))
                .andExpect(jsonPath("$[0].genres[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].genres[0].name", equalTo("драма")))
                .andExpect(jsonPath("$[0].genres[1].id", equalTo(2)))
                .andExpect(jsonPath("$[0].genres[1].name", equalTo("криминал")))
                .andExpect(jsonPath("$[0].reviews", hasSize(1)))
                .andExpect(jsonPath("$[0].reviews[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].reviews[0].user.id", equalTo(2)))
                .andExpect(jsonPath("$[0].reviews[0].user.nickName", equalTo("darlene.edwards15@example.com")))
                .andExpect(jsonPath("$[0].reviews[0].text", equalTo("Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.")));
    }
}
