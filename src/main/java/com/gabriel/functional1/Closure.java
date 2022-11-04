package com.gabriel.functional1;

import java.util.function.Function;

public class Closure {

    public static void main(String[] args) {
        // The scope of variable inside function is internal;
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
            String name = "Shown";
            return () -> "Hello " + name;
        };
        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());
    }
}
