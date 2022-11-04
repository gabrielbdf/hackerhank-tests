package com.gabriel.solveds.timeconversion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String isAmPm = s.substring(s.length() - 2, s.length());
        String restOf = s.substring(0, s.length() - isAmPm.length());
        String[] arrValues = restOf.split(":");
        Integer hour = Integer.valueOf(arrValues[0]);
        if (isAmPm.equalsIgnoreCase("PM")) {
            hour = hour == 12 ? 12 : hour + 12;
        } else if (isAmPm.equalsIgnoreCase("AM")) {
            hour = hour == 12 ? 0 : hour;
        }
        String horaStr = hour < 10 ? "0" + String.valueOf(hour) : String.valueOf(hour);
        return horaStr + ":" + arrValues[1] + ":" + arrValues[2];

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        InputStream is = Solution.class.getClassLoader().getResourceAsStream("timeConversion.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            String result = Result.timeConversion(s);
            System.out.println(result);
        }

        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
