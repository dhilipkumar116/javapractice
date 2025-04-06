package com.javapractice.streams;

import java.util.List;

public class _07_Peek {
    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(10, "CCC"),
                new Movie(20, "DDD")
        );


        /*
        *
        * peek method is not a terminating method like forEach
        * peek method is used to debug the intermediate pipeline results.
        *
        * */

        movieList.stream().filter(movie -> movie.getLikes() > 10)
                .peek(movie -> System.out.println("filtered : "+ movie.getTitle()))
                .map(movie -> movie.getTitle())
                .peek(title -> System.out.println("mapped : "+ title))
                .forEach(System.out::println);
        ;

    }
}
