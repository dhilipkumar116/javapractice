package com.javapractice.functionalinterface;

import java.util.function.Function;

public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        Function<String, Integer> map = (str) -> str.length();
        var length = map.apply("dhilip");
        System.out.println(length);


//       composing two func -------

        Function<String , String> replaceColon = (str) -> str.replace(":", "=");
        Function<String, String> addBraces = (str) -> "{"+str+"}";

        var result = replaceColon.andThen(addBraces).apply("key:value");

        result = addBraces.compose(replaceColon).apply("key:value");
        System.out.println(result);

    }
}
