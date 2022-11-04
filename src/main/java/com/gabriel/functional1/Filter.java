package com.gabriel.functional1;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {

        Integer listArr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = Stream.of(listArr)
                .filter((x) -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evens);

        String[] words = { "Gabriel", "Alline", "Renato", "Evellyn", "Ana Carolina", "Yuri" };

        Function<String, Predicate<String>> containsLetter = (l) -> {
            return (str) -> str.toLowerCase().contains(l.toLowerCase());
        };
        Predicate<String> containL = containsLetter.apply("l");
        Function<String, String> countLetter = (s) -> s + ": " + s.length();

        List<String> containsAList = Stream.of(words)
                .filter(containL)
                .map(countLetter)
                .collect(Collectors.toList());

        System.out.println(containsAList);

    }
}
