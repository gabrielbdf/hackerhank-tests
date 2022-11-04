package com.gabriel.solveds.plusminus;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result { 

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int[] initialArr = new int[] { 0, 0, 0 };
        arr.forEach(n -> {
            initialArr[0] += n > 0 ? 1 : 0;
            initialArr[1] += n < 0 ? 1 : 0;
            initialArr[2] += n == 0 ? 1 : 0;
        });
        for (int i = 0; i < initialArr.length; i++) {
            System.out.println((double) initialArr[i] / arr.size());
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        InputStream is = Solution.class.getClassLoader().getResourceAsStream("plus-minus.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        //

        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
