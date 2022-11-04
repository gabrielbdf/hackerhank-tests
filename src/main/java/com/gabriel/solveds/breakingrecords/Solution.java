package com.gabriel.solveds.breakingrecords;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {

        Integer recordMin = scores.get(0);
        Integer recordMax = scores.get(0);
        Set<Integer> minList = new LinkedHashSet<>();
        Set<Integer> maxList = new LinkedHashSet<>();
        for (Integer c : scores) {
            recordMin = c <= recordMin ? c : recordMin;
            recordMax = c >= recordMax ? c : recordMax;
            minList.add(recordMin);
            maxList.add(recordMax);
        }

        return Arrays.asList(maxList.size() - 1, minList.size() - 1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        InputStream is = Solution.class.getClassLoader().getResourceAsStream("breakingRecords.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        //

        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            List<Integer> arr = Stream.of(s.replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            List<Integer> result = Result.breakingRecords(arr);
            System.out.println(result);
        }


        bufferedReader.close();
    }
}
