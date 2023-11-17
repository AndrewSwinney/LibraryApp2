package com.barclays.repository;

import com.barclays.model.Member;
import com.barclays.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    List<Movie> findByTitleContains(String filter);

    List<Movie> findByGenreContains(String filter);

}
