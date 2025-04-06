package com.javapractice.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _09_Collectors {

    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(10, "CCC"),
                new Movie(20, "DDD")
        );

        /*
        *
        * collectors used to collect the results into different data structure.
        *
        * */

        var result1 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toSet());
        var result2 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toList());
        var result3 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(m->m.getTitle(), m->m.getLikes()));
        System.out.println(result3);


        System.out.println("convert the list to map and save value as movie");
        var result4 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(m->m.getTitle(), m->m));
        System.out.println(result4);



        System.out.println("(diff version)convert the list to map and save value as movie");
        // this method is same as above
        var result5 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));
        System.out.println(result5);

        System.out.println("summing movie likes");
        var result6 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));
        System.out.println(result6);


        System.out.println("summarizing gives all stats(min, max, avg, count)");
        var result7 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println(result7);


        System.out.println("concat name of the movie");
        var result8 = movieList.stream()
                .filter(movie -> movie.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println(result8);

    }
}
