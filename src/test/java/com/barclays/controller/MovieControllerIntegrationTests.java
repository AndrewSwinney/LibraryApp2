package com.barclays.controller;

import com.barclays.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovieControllerIntegrationTests {

    @Autowired
    MovieController movieController;

    @Test
    public void testGetAllMovies() {
        List<Movie> movies = movieController.getAllMovies("", "");
        assertEquals(1, movies.size());
    }

    @Test
    public void testGetMovieByGenre() {
        List<Movie> movies = movieController.getAllMovies("", "Crime");
        assertEquals(1, movies.size());
    }

    @Test
    public void testInvalidGenre() {
        List<Movie> movies = movieController.getAllMovies("", "Funny");
        assertEquals(0, movies.size());
    }

    @Test
    public void testGetMember1() {
        Movie movie = movieController.getMovie(1);
        assertEquals("Goodfellas", movie.getTitle());
    }
}
