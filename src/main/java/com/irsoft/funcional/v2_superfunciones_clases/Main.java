package com.irsoft.funcional.v2_superfunciones_clases;

import com.irsoft.funcional.v2_superfunciones_clases.clases.Aleatorio;
import com.irsoft.funcional.v2_superfunciones_clases.clases.SoloImpares;
import com.irsoft.funcional.v2_superfunciones_clases.clases.SoloPares;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // ¿Qué queremos hacer?

        // 1.- Crear lista de enteros
        List<Integer> numeros = Superfunciones.proveer(10, new Aleatorio());
        System.out.println(numeros);

        // 2.- Quedarme solo con los filtrados
        List<Integer> filtrados = Superfunciones.filtrar(numeros, new SoloImpares());
        System.out.println(filtrados);

        // 3.- Pasar cada número al cuadrado
        List<Integer> cuadrados = elevarAlCuadrado(filtrados);
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

    private List<Integer> filtrarPares(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        // Se recorre la lista y se agrega a la lista resultado solo
        // los números de la lista que sean pares.
        for (Integer numero : numeros) {
            if (numero % 2 == 0) resultado.add(numero);
        }
        return resultado;
    }

    private List<Integer> elevarAlCuadrado(List<Integer> pares) {
        List<Integer> resultado = new ArrayList<>();
        // Se recorre la lista y se agrega a la lista el cuadrado
        // de los números originales.
        for (Integer numero : pares) {
            resultado.add(numero * numero);
        }
        return resultado;
    }
    private List<Integer> mostrarLista(List<Integer> numeros) {
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
        return numeros;
    }
    private Integer sumarLista(List<Integer> mostrados) {
        Integer total = 0;
        for (Integer numero : mostrados) {
            total += numero;
        }
        return total;
    }
}
