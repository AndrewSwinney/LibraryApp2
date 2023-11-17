package com.barclays.service;

import com.barclays.model.Book;
import com.barclays.model.Member;
import com.barclays.model.Movie;
import com.barclays.repository.BookRepository;
import com.barclays.repository.MemberRepository;
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
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book findByBookId(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseGet(() -> new Book("Default Message: Nothing found"));
    }

    @Override
    public List<Book> findByTitleContains(String filter) {
        return bookRepository.findByTitleContains(filter);
    }

    @Override
    public List<Book> findByGenreContains(String genre) {
        return bookRepository.findByGenreContains(genre);
    }

}

