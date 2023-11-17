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

public class Member {

    @Id
    @GeneratedValue

    private int id;
    private String name;

    private String emailAddress;

    public Member(String name) {
        this.name = name;
    }
}
