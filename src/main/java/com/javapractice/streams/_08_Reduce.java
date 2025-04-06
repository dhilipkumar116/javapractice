package com.javapractice.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class _08_Reduce {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(10, "CCC"),
                new Movie(20, "DDD")
        );

        System.out.println("Count items");
        System.out.println(movieList.stream().count());

        System.out.println("any match");
        System.out.println(movieList.stream().anyMatch(movie -> movie.getLikes() > 15));

        System.out.println("all match");
        System.out.println(movieList.stream().allMatch(movie -> movie.getLikes() > 15));

        System.out.println("none match");
        System.out.println(movieList.stream().noneMatch(movie -> movie.getLikes() > 15));

        System.out.println("find first");
        System.out.println(movieList.stream().findFirst().get().getTitle());

        System.out.println("find first with filter");
        movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .findFirst()
                .ifPresent(movie -> System.out.println(movie.getTitle()));


        System.out.println("find any with filter");
        movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .findAny()
                .ifPresent(movie -> System.out.println(movie.getTitle()));



        /*
        *
        * In a parallel stream, the element returned by findAny()
        * may not necessarily be the first one encountered in the original stream.
        *
        * */
        System.out.println("find any with parallel stream");
        movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .parallel() // Make the stream parallel
                .findAny()
                .ifPresent(movie -> System.out.println(movie.getTitle()));


        System.out.println("max");
        var maxResult = movieList.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println(maxResult.getTitle());

        System.out.println("min");
        var minResult = movieList.stream()
                .min(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println(minResult.getTitle());


        /*
        * reduce method
        * [10,20,30]
        * [30,30]
        * [30]
        *
        * */

        System.out.println("sum using reduce method");
        // optional class is used to handle null values
        Optional<Integer> sum = movieList.stream()
                .map(movie -> movie.getLikes())
                .reduce((a,b)-> a+b);
        System.out.println(sum.orElse(0));


    }
}
