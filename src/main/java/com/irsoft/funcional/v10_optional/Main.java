package com.irsoft.funcional.v10_optional;

import java.util.Comparator;
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

        Integer maximo = Flujo.proveer(10, this::randomInt)
                //.filtrar(NumbersUtils::esPrimo)
                .filtrar(valor -> valor >= 10)
                //.ordenar((valor1, valor2) -> valor1 - valor2)
                .ordenar(Integer::compareTo)
                .transformar(NumbersUtils::elevarAlCuadrado)
                //.transformar(valor -> new Descripcion(valor))
                .transformar(Descripcion::new)
                .actuar(System.out::println)
                //.transformar(description -> description.getValue())
                .transformar(Descripcion::getValue)
                //.reducir(0, Integer::sum);
                // De menor a mayor
                //.max((valor1, valor2) -> valor1 - valor2)
                //.max(Integer::compare)
                // Orden inverso
                //.max(Comparator.reverseOrder())
                .max(Comparator.naturalOrder());

        double maxDouble = maximo.doubleValue();
        System.out.println("Máximo: " + maxDouble);
    }

    private Integer randomInt() {
        return random.nextInt(10);
    }
}
