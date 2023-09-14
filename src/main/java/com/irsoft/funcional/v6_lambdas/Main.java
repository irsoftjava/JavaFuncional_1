package com.irsoft.funcional.v6_lambdas;

import com.irsoft.funcional.v6_lambdas.interfaces.*;

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

        Integer total = Flujo.proveer(10, () -> random.nextInt(10))
                .filtrar(valor -> valor % 2 == 0)
                .transformar(valor -> valor * valor)
                .actuar(valor -> System.out.println(valor))
                .reducir(0, (val1, val2) -> val1 + val2);

        System.out.println("Reducción: " + total);
    }
}
