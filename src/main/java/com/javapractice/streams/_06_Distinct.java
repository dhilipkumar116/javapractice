package com.javapractice.streams;

import java.util.List;

public class _06_Distinct {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(10, "CCC"),
                new Movie(20, "DDD")
        );

        movieList.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(like -> System.out.println(like));
    }
}
