package com.barclays.controller;

import com.barclays.model.Book;
import com.barclays.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class BookControllerIntegrationTests {

    @Autowired
    BookController bookController;

    @Test
    public void testGetAllMembers() {
        List<Book> books = bookController.getAllBooks("", "", "");
        assertEquals(1, books.size());
    }

    @Test
    public void testGetMember1() {
        Book book = bookController.getBook(1);
        assertEquals("Remains of the Day", book.getTitle());
    }


}
