package com.gabriel.functional1;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapInJava {

    public static void main(String[] args) {

        Integer listArr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        Function<Integer, Integer> bitCount = (x) -> Integer.bitCount(x);

        List<Integer> countBit = Stream.of(listArr)
                .map(Integer::bitCount)
                .collect(Collectors.toList());

        System.out.println(countBit);
    }

}
