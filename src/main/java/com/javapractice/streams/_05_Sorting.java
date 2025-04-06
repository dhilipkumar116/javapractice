package com.javapractice.streams;

import java.util.Comparator;
import java.util.List;

public class _05_Sorting {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(10, "CCC"),
                new Movie(20, "DDD")
        );

        movieList.stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(movie -> System.out.println(movie.getTitle()));
    }
}
