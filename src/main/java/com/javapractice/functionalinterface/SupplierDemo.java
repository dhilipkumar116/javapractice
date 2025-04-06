package com.javapractice.functionalinterface;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Double> getRandom = () -> Math.random();
        var random = getRandom.get(); // we need to explicitly call the get method in supplier
        System.out.println(random);
    }
}
