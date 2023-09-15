package com.irsoft.funcional.v10_optional;

import java.util.Random;

public class Main {

    Random random = new Random();
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Constructor de Main
     */
    public Main() {

        Integer total = Flujo.proveer(10, this::randomInt)
                .filtrar(NumbersUtils::esPrimo)
                //.ordenar((valor1, valor2) -> valor1 - valor2)
                .ordenar(Integer::compareTo)
                .transformar(NumbersUtils::elevarAlCuadrado)
                //.transformar(valor -> new Descripcion(valor))
                .transformar(Descripcion::new)
                .actuar(System.out::println)
                //.transformar(description -> description.getValue())
                .transformar(Descripcion::getValue)
                .reducir(0, Integer::sum);

        System.out.println("Reducción: " + total);
    }

    private Integer randomInt() {
        return random.nextInt(10);
    }
}
