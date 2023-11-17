package com.barclays.service;

import com.barclays.model.Book;


import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    Book findByBookId(int id);

    List<Book> findByTitleContains(String filter);

    List<Book> findByAuthorContains(String author);

    List<Book> findByGenreContains(String genre);

}
