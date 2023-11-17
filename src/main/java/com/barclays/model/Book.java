package com.barclays.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Book {

    @Id
    @GeneratedValue

    private int id;

    private int isbn;

    private String genre;

    private String title;

    private String author;

    private String genre;

    private int yearPublished;

    public Book(String title) {
        this.title = title;
    }


}
