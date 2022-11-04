package com.gabriel.functional1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountBits {

    public static void main(String[] args) {
        int arr[] = new int[] { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };

        int[] res = Arrays.stream(arr)
                .boxed()
                .sorted()
                .map((x) -> new int[] { Integer.bitCount(x), x })
                .sorted((a, b) -> a[0] - b[0])
                .map((x) -> x[1])
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(res);
    }

}
