package com.javapractice.streams;

import java.util.List;

public class _04_Slicing {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(13, "CCC"),
                new Movie(20, "DDD")
        );

        System.out.println("Take first 2 item");
        movieList.stream()
                .limit(2)
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("Skip first 2 item");
        movieList.stream()
                .skip(2)
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("takeWhile (the moment condition fails it stop the execution)");
        movieList.stream()
                .takeWhile(movie -> movie.getLikes() < 15)
                .forEach(movie -> System.out.println(movie.getTitle()));


        System.out.println("dropWhile (opposite to takeWhile)");
        movieList.stream()
                .dropWhile(movie -> movie.getLikes() < 15)
                .forEach(movie -> System.out.println(movie.getTitle()));

    }
}
