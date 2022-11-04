package com.gabriel.solveds.minimaxsum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long min = arr.get(0);
        long max = arr.get(0);
        long total = 0;
        for (Integer num : arr) {
            total += num;
            min = num < min ? num : min;
            max = num > max ? num : max;
        }
        System.out.println((total - max) + " " + (total - min));

    }

    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        InputStream is = Solution.class.getClassLoader().getResourceAsStream("min-max-sum.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        //

        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
