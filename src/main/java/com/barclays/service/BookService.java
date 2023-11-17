package com.barclays.service;

import com.barclays.model.Book;
import com.barclays.model.Member;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    Book findByBookId(int id);

    List<Book> findByTitleContains(String filter);
}
