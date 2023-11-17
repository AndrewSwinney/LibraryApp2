package com.barclays.controller;


import com.barclays.model.Book;
import com.barclays.service.BookService;
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
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;

    }

    @GetMapping("/books")
    public List<Book> getAllBooks(@PathParam("filter") String filter,
                                  @PathParam ("author") String author,
                                  @PathParam("genre") String genre) {
        log.debug("In the getAll Books method");
        List<Book> books = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            log.debug("In the getAll Books method: " + filter);
            books = bookService.findByTitleContains(filter);
        }
        else if (StringUtils.isNotBlank(author)) {
            books = bookService.findByAuthorContains(author);
        }
        else if (StringUtils.isNotBlank(genre)) {
            books = bookService.findByGenreContains(genre);
        }
        else {
            books = bookService.findAllBooks();
        }
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        log.debug("In the getBook method: " + id);
        return bookService.findByBookId(id);
    }
}
