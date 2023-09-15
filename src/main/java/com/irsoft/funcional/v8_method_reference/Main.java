package com.irsoft.funcional.v8_method_reference;

import java.util.Random;

import static com.irsoft.funcional.v8_method_reference.NumbersUtils.elevarAlCuadrado;
import static com.irsoft.funcional.v8_method_reference.NumbersUtils.esPrimo;

public class Main {

    Random random = new Random();
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Constructor de Main
     */
    public Main() {

        Integer total = Flujo.proveer(10, () -> randomInt())
                .filtrar(valor -> esPrimo(valor))
                .transformar(valor -> elevarAlCuadrado(valor))
                .actuar(valor -> System.out.println(valor))
                .reducir(0, (val1, val2) -> Integer.sum(val1, val2));

        System.out.println("Reducción: " + total);
    }

    private Integer randomInt() {
        return random.nextInt(10);
    }
}
