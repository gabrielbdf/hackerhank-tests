package com.gabriel.solveds.camel_case_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        
          Scanner keyboard = new Scanner(System.in);
          keyboard.nextLine();
          keyboard.close();
         

        InputStream is = Solution.class.getClassLoader().getResourceAsStream("camel_case_4.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            String result = Solution.formatedText(s);
            System.out.println(result);
        }

    }

    public static String formatedText(String entrada) {
        String[] line = entrada.split(";");
        String operation = line[0];
        String type = line[1];
        // Remove special characters
        String[] prhaseArr = line[2].replaceAll("[^a-zA-Z0-9]", " ").trim().split("");

        StringBuilder sb = new StringBuilder();
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < prhaseArr.length; i++) {
            char currentChar = prhaseArr[i].charAt(0);
            int type2 = Character.getType(currentChar);
            sb.append(type2 == 1 ? " " + prhaseArr[i].toLowerCase() : prhaseArr[i]);
        }
        prhaseArr = sb.toString().trim().split(" ");
        for (int i = 0; i < prhaseArr.length; i++) {
            if (operation.equalsIgnoreCase("S")) {
                finalResult.append(prhaseArr[i] + " ");
            }
            if (operation.equalsIgnoreCase("C")) {
                finalResult.append(prhaseArr[i].replaceFirst(String.valueOf(prhaseArr[i].charAt(0)),
                        String.valueOf(prhaseArr[i].charAt(0)).toUpperCase()));

            }
        }
        if (operation.equalsIgnoreCase("C")) {
            switch (type) {
                case "M":
                    finalResult.replace(0, 1, finalResult.substring(0, 1).toLowerCase()).append("()");
                case "V":
                    finalResult.replace(0, 1, finalResult.substring(0, 1).toLowerCase());
            }
        }

        return finalResult.toString().trim();

    }
}