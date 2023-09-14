package com.irsoft.funcional_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // ¿Qué queremos hacer?

        // 1.- Crear lista de enteros
        List<Integer> numeros = crearLista();

        // 2.- Quedarme solo con los pares
        List<Integer> pares = filtrarPares(numeros);
        // 3.- Pasar cada número al cuadrado
        // 4.- Mostrar cada cuadrado por pantalla
        // 5.- Obtener la suma de los cuadrados.
    }

    private List<Integer> crearLista() {
        // Esto es una manera de hacerlo
        // return Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
        // Esta es otra manera de hacerlo
        return List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
    }

    private List<Integer> filtrarPares(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        // Se recorre la lista y se agrega a la lista resultado solo
        // los números de la lista que sean pares.
        for (Integer numero : numeros) {
            if (numero % 2 == 0) resultado.add(numero);
        }
        return resultado;
    }
}
