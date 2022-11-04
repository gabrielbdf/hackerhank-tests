package com.gabriel.solveds.divible_sum_pairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER k
     * 3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int divisibles = 0;
        for (int i = 0; i < n; i++) {
            int f = ar.get(i);
            for (int j = 0; j < n; j++) {
                int s = ar.get(j);
                if (i < j) {
                    if ((f + s) % k == 0) {
                        divisibles++;
                    }
                }
            }
        }
        return divisibles;

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        int n = 6;
        int k = 5;
        List<Integer> ar = Arrays.asList(1, 2, 3, 4, 5, 6);

        int result = Result.divisibleSumPairs(n, k, ar);

        System.out.println(result);

    }
}
