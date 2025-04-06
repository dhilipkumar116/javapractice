package com.javapractice.streams;

public class Movie {

    private int likes;
    private String title;
    private Genre genre;

    public Movie(int likes, String title, Genre genre) {
        this.likes = likes;
        this.title = title;
        this.genre = genre;
    }

    public Movie(int likes, String title) {
        this.likes = likes;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public Genre getGenre() {
        return genre;
    }
}
