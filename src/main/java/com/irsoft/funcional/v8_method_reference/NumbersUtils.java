package com.irsoft.funcional.v8_method_reference;

public class NumbersUtils {

    private NumbersUtils() {
    }

    public static boolean esPrimo(Integer valor) {
        for (int i = 2; i < valor; i++) {
            if (valor % i == 0) return false;
        }
        return true;
    }

    public static int elevarAlCuadrado(Integer valor) {
        return valor * valor;
    }
}
