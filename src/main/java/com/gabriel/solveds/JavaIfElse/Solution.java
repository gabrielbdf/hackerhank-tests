package com.gabriel.solveds.JavaIfElse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// If  is odd, print Weird
// If  is even and in the inclusive range of  2 to 5 , print Not Weird
// If  is even and in the inclusive range of  to , print Weird
// If  is even and greater than , print Not Weird
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        String actualStatus = "";
        if (N % 2 != 0) {
            actualStatus = "Weird";
        }
        if (N % 2 == 0 && N >= 2 && N <= 5) {
            actualStatus = "Not Weird";
        }
        if (N % 2 == 0 && N >= 6 && N <= 20) {
            actualStatus = "Weird";
        }
        if (N % 2 == 0 && N > 20) {
            actualStatus = "Not Weird";
        }

        System.out.println(actualStatus);

        bufferedReader.close();
    }
}
