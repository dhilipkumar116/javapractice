package com.javapractice.streams;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _10_Grouping {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA", Genre.ACTION),
                new Movie(15, "BBB", Genre.ACTION),
                new Movie(10, "CCC", Genre.THRILLER)
        );


        System.out.println("group the result into list");
        var result1 = movieList.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println(result1);

        System.out.println("group the result into set");
        var result2 = movieList.stream()
                .collect(
                        Collectors.groupingBy(
                                Movie::getGenre,
                                Collectors.toSet()
                        )
                );
        System.out.println(result2);

        System.out.println("group the result and count the values");
        var result3 = movieList.stream()
                .collect(
                        Collectors.groupingBy(
                                Movie::getGenre,
                                Collectors.counting()
                        )
                );
        System.out.println(result3);

        System.out.println("group the result and join the values");
        var result4 = movieList.stream()
                .collect(
                        Collectors.groupingBy(
                                Movie::getGenre,
                                Collectors.mapping(
                                        Movie::getTitle,
                                        Collectors.joining(", ")
                                )
                        )
                );
        System.out.println(result4);

    }
}
