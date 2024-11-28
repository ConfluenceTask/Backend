package com.example.demo.model;

import java.time.LocalDate;


public class Card {

    private Long id;
    private String title;
    private LocalDate dateOfCreation;

    public Card(Long id, String title) {
        this.id = id;
        this.title = title;
        this.dateOfCreation = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }
}
