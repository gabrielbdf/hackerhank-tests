package com.gabriel.functional1;

import java.util.function.Function;

public class ReturningFunction {

    protected static class MyMath {

        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> x * y;
        }
    }

    public static void main(String[] args) {

        NoArgFunction<NoArgFunction<String>> createPrinter = () -> () -> "Olá como vai";
        NoArgFunction<String> greeter = createPrinter.apply();
        System.out.println(greeter.apply());

        Function<Integer, Integer> timesThree = MyMath.createMultiplier(4);
        System.out.println(timesThree.apply(3));

    }

}
