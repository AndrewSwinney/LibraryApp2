package com.barclays.service;

import com.barclays.model.Member;
import com.barclays.model.Movie;
import com.barclays.repository.MemberRepository;
import com.barclays.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public List<Movie> findAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    @Override
    public Movie findByMovieId(int id) {
        Optional<Movie> movies = movieRepository.findById(id);
        return movies.orElseGet(() -> new Movie("Default Member: Nothing found"));
    }

    @Override
    public List<Movie> findByMovieTitleContains(String filter) {
        return movieRepository.findByTitleContains(filter);
    }

    @Override
    public List<Movie> findByGenreContains(String genre) {
        return movieRepository.findByGenreContains(genre);
    }
}
