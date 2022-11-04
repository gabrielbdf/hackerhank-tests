package com.gabriel.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {

        String[] words = { "Gabriel", "Alline", "Renato", "Evellyn", "Ana Carolina", "Yuri" };

        BinaryOperator<Integer> totalLength = (acc, x) -> acc + x;

        List<Integer> res1 = Stream.of(words)
                .map(x -> x.replace(" ", "").length())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(res1);

        Integer res2 = Stream.of(words)
                .collect(Collectors.joining())
                .length();

        System.out.println(res2);

    }
}