package com.javapractice.streams;

import java.util.List;
import java.util.stream.Stream;

public class _02_Map {

    public static void main(String[] args) {


        List<Movie> movieList = List.of(
                new Movie(10, "AAA"),
                new Movie(15, "BBB"),
                new Movie(13, "CCC")
        );

        /*
        *
        * mapToInt is a primitive method
        * by using primitive mapping method,
        * we can reduce the overhead of autoboxing and unboxing.
        *
        * */
        movieList.stream()
                .mapToInt(movie -> movie.getLikes())
                .forEach(likes -> System.out.println(likes));

        movieList.stream()
                .map(movie -> movie.getTitle())
                .forEach(title -> System.out.println(title));

        // flat map
        var stream1 = Stream.of(List.of(1,2,3), List.of(4,5,6));
        stream1
                .flatMap(list -> list.stream())
                .forEach(list -> System.out.println(list));


        var stream2 = Stream.of(List.of(1,2,3), List.of(4,5,6, List.of(7,8)));
        stream2
                .flatMap(list -> flatten(list).stream())
                .forEach(list -> System.out.println(list));

    }

    private static List<Object> flatten(Object obj) {
        if (obj instanceof List) {
            // If it's a list, recursively flatten its elements
            return flattenList((List<?>) obj);
        } else {
            // If it's not a list, return it as a single-element list
            return List.of(obj);
        }
    }

    private static List<Object> flattenList(List<?> list) {
        // Recursively flatten elements in the list
        return list.stream()
                .flatMap(e -> flatten(e).stream())
                .toList();
    }
}
