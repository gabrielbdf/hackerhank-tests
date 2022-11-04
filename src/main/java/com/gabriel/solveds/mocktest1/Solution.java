package com.gabriel.solveds.mocktest1;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int midle;
        arr.sort((a, b) -> a - b);
        int midleIndex = arr.size() / 2;
        if (arr.size() % 2 != 0) {
            midle = arr.get(midleIndex - 1);
        } else {
            midle = arr.get(midleIndex) + arr.get(midleIndex - 1) / 2;
        }

        return midle;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream is = Solution.class.getClassLoader().getResourceAsStream("findMedian.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
