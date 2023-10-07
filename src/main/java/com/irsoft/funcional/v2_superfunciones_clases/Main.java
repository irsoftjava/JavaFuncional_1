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
        List<Integer> numeros = Superfunciones.proveer(10, new Aleatorio());
        System.out.println(numeros);

        // 2.- Quedarme solo con los filtrados
        List<Integer> filtrados = Superfunciones.filtrar(numeros, new SoloPares());
        System.out.println(filtrados);

        // 3.- Obtener el cuadrado de cada número
        List<Integer> transformados = Superfunciones.transformar(filtrados, new AlCubo());
        System.out.println(transformados);

        // 4a.- Mostrar cada cuadrado por pantalla y retorna lista
        List<Integer> actuados = Superfunciones.actuar(transformados, new Impresor());
        // 4b.- Mostrar cada cuadrado por pantalla y no retorna nada
        //Superfunciones.consumir(transformados, new Impresor());

        // 5.- Obtener la suma de los transformados.
        Integer total = Superfunciones.reducir(actuados, 1, new Multiplicador());
        System.out.println("Reducción: " + total);
    }
}
