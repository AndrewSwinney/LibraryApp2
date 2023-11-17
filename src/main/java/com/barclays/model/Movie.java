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

public class Movie {

    @Id
    @GeneratedValue

    private int id;
    private String title;
    private String leadActor;
    private String director;
    private String screenWriter;
    private int releaseYear;
    private String genre;
    private double rating;

    public Movie(String title) {
        this.title = title;
    }

}
