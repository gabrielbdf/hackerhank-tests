package com.gabriel.solveds.lounchpod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Programa {

    public static void main(String entrada[]) {

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        var dia22 = LocalDateTime.of(2022, 9, 22, 22, 34);
        var daqui3meses = dia22.plusDays(90).plusMinutes(50);

        int vetor[] = new int[5];
        vetor[3] = 40;

        String res = Arrays.stream(vetor)
                .mapToObj(Programa::valorDo)
                .collect(Collectors.joining(","));

        System.out.println(res);
        System.out.println(formater.format(dia22));
        System.out.println(formater.format(daqui3meses));
        System.exit(0);

    }

    public static String valorDo(Object obj) {
        return String.valueOf(obj);
    }

}