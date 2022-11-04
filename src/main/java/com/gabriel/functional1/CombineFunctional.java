package com.gabriel.functional1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CombineFunctional {

    protected static class MyMath {

        public static Map<String, Integer> add(Integer x, Integer y) {
            return Map.of("+", x + y);
        }

        public static Map<String, Integer> subtract(Integer x, Integer y) {
            return Map.of("-", x - y);
        }

        public static Map<String, Integer> multiply(Integer x, Integer y) {
            return Map.of("*", x * y);
        }

        public static Map<String, Integer> combine(BiFunction<Integer, Integer, Map<String, Integer>> func, Integer x,
                Integer y) {
            return func.apply(x, y);
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 10)
                .forEach(CombineFunctional::tabuada);
    }

    public static void tabuada(Integer num) {
        int[][] values = IntStream
                .range(0, 10)
                .mapToObj(i -> new int[] { num, i })
                .toArray(int[][]::new);

        String res = Stream.of(values)
                .map(v -> new Object[] { v[0], v[1], MyMath.combine(MyMath::multiply, v[0], v[1]) })
                .map(v -> {
                    StringBuilder sb = new StringBuilder();
                    Map<String, Integer> v2 = (Map<String, Integer>) v[2];
                    sb.append(v[0]).append(v2.keySet().iterator().next()).append(v[1]).append("=")
                            .append(v2.values().iterator().next());
                    return sb.toString();
                }).collect(Collectors.joining("\n"));

        System.out.println(res);
    }
}
