package com.barclays.service;

import com.barclays.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAllMovies();

    Movie findByMovieId(int id);

    List<Movie> findByMovieTitleContains(String filter);

    List<Movie> findByGenreContains(String genre);
}
