package com.irsoft.funcional.v8_method_reference;

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
                .filtrar(valor -> {
                    for (int i = 2; i < valor; i++) {
                        if (valor % i == 0) return false;
                    }
                    return true;
                })
                .transformar(valor -> valor * valor)
                .actuar(valor -> System.out.println(valor))
                .reducir(0, (val1, val2) -> val1 + val2);

        System.out.println("Reducción: " + total);
    }
}
