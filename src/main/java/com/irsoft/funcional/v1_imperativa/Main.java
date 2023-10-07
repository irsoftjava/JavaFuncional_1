package com.irsoft.funcional.v1_imperativa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // ¿Qué queremos hacer?

        // 1.- Crear lista de enteros
        List<Integer> numeros = crearLista();
        System.out.println(numeros);

        // 2.- Quedarme solo con los pares
        List<Integer> pares = filtrarPares(numeros);
        System.out.println(pares);

        // 3.- Pasar cada número al cuadrado
        List<Integer> cuadrados = elevarAlCuadrado(pares);
        System.out.println(cuadrados);

        // 4.- Mostrar cada cuadrado por pantalla
        List<Integer> mostrados = mostrarLista(cuadrados);

        // 5.- Obtener la suma de los cuadrados.
        Integer total = sumarLista(mostrados);
        System.out.println("Suma de Cuadrados " + total);
    }


    private List<Integer> crearLista() {
        // Esto es una manera de hacerlo
        // return Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
        // Esta es otra manera de hacerlo
        return List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
    }

    private List<Integer> filtrarPares(List<Integer> xs) {
        List<Integer> resultado = new ArrayList<>();
        // Se recorre la lista y se agrega a la lista resultado solo
        // los números de la lista que sean pares.
        for (Integer numero : xs) {
            if (numero % 2 == 0) resultado.add(numero);
        }
        return resultado;
    }

    private List<Integer> elevarAlCuadrado(List<Integer> xs) {
        List<Integer> resultado = new ArrayList<>();
        // Se recorre la lista y se agrega a la lista el cuadrado
        // de los números originales.
        for (Integer numero : xs) {
            resultado.add(numero * numero);
        }
        return resultado;
    }
    private List<Integer> mostrarLista(List<Integer> xs) {
        for (Integer numero : xs) {
            System.out.println(numero);
        }
        return xs;
    }
    private Integer sumarLista(List<Integer> xs) {
        Integer total = 0;
        for (Integer numero : xs) {
            total += numero;
        }
        return total;
    }
}
