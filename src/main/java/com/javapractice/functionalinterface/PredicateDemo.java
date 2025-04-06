package com.javapractice.functionalinterface;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {


        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.startsWith("}");

        Predicate<String> hasBothBraces = hasLeftBrace.and(hasRightBrace);
        var result = hasBothBraces.test("{key:value");
        System.out.println(result);

    }
}
