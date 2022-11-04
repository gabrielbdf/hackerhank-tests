package com.gabriel.functional1;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HighOrderFunction {

    public static void main(String[] args) {

        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> preventDivideByZero = (
                func) -> (x, y) -> {
                    if (y == 0f) {
                        System.err.println("Não pode dividir por zero");
                        return 0f;
                    }
                    return func.apply(x, y);
                };
        BiFunction<Float, Float, Float> safeDivide = preventDivideByZero.apply(divide);

        System.out.println(safeDivide.apply(3f, 2.3f));
    }
}
