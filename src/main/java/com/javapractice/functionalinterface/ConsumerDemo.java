package com.javapractice.functionalinterface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    /*
    * func interface are the interface which contains only one method inside it.
    * */
    public static void main(String[] args) {
        List<String> list  = List.of("a","b","c");
        Consumer<String> print = (item) -> System.out.println(item);
        Consumer<String> printUpperCase = (item) -> System.out.println(item.toUpperCase());
        list.forEach(print.andThen(printUpperCase).andThen(print));
    }
}
