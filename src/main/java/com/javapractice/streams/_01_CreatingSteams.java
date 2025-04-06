package com.javapractice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _01_CreatingSteams {

    public static void main(String[] args) {

        // from array
        int[] arr = {1,2,3,4};
        Arrays.stream(arr);


        // from collections
        var list = new ArrayList<>(List.of(1,2,3));
        list.stream();

        // from arbitrary objects
        Stream.of(1,2,3,4,5);

        // infinite and finite steams
        Stream.generate(() -> Math.random())
                .limit(3)
                .forEach(val -> System.out.println(val));

        Stream.iterate(1, (n) -> n+1)
                .limit(3)
                .forEach(val -> System.out.println(val));

    }
}
