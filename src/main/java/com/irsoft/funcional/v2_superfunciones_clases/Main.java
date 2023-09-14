package com.irsoft.funcional.v2_superfunciones_clases;

import com.irsoft.funcional.v2_superfunciones_clases.clases.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // ¿Qué queremos hacer?

        // 1.- Crear lista de enteros
        List<Integer> numeros = Superfunciones.proveer(10, new Naturales());
        System.out.println(numeros);

        // 2.- Quedarme solo con los filtrados
        List<Integer> filtrados = Superfunciones.filtrar(numeros, new SoloPares());
        System.out.println(filtrados);

        // 3.- Obtener el cuadrado de cada número
        List<Integer> cuadrados = Superfunciones.transformar(filtrados, new ALCubo());
        System.out.println(cuadrados);

        // 4.- Mostrar cada cuadrado por pantalla
        List<Integer> mostrados = mostrarLista(cuadrados);

        // 5.- Obtener la suma de los cuadrados.
        Integer total = sumarLista(mostrados);
        System.out.println("Suma de Cuadrados " + total);
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
