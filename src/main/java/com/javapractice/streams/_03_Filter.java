package com.javapractice.streams;

import java.util.List;

public class _03_Filter {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(13, "CCC")
        );

        movieList.stream()
                .filter(e -> e.getLikes() > 10)
                .forEach(movie -> System.out.println(movie.getTitle()));
    }
}
