package com.barclays.repository;

import com.barclays.model.Book;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByTitleContains(String filter);

    List<Book> findByGenreContains(String genre);
}
