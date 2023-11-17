package com.barclays.controller;

import com.barclays.model.Member;
import com.barclays.model.Movie;
import com.barclays.service.MovieService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@Slf4j
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;

    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(@PathParam("filter") String filter, @PathParam("genre") String genre) {
        log.debug("In the getAll Movies method");
        List<Movie> movies = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            log.debug("In the getAll Members method: " + filter);
            movies = movieService.findByMovieTitleContains(filter);
        }
        else if (StringUtils.isNotBlank(genre)) {
            movies = movieService.findByGenreContains(genre);
        }
        else {
            movies = movieService.findAllMovies();
        }
        return movies;
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        log.debug("In the getMovies method: " + id);
        return movieService.findByMovieId(id);
    }
}
