package com.javapractice.streams;

import java.util.List;
import java.util.stream.Collectors;

public class _11_Partition {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA", Genre.ACTION),
                new Movie(15, "BBB", Genre.ACTION),
                new Movie(20, "CCC", Genre.THRILLER)
        );


        var result1 = movieList.stream()
                .collect(
                        Collectors.partitioningBy(
                                m -> m.getLikes() > 15,
                                Collectors.mapping(
                                        Movie::getTitle,
                                        Collectors.joining(", ")
                                )
                        )
                );

        System.out.println(result1);

    }
}
