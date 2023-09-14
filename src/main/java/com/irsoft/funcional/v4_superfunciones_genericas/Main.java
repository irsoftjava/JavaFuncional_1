package com.irsoft.funcional.v4_superfunciones_genericas;

import com.irsoft.funcional.v4_superfunciones_genericas.interfaces.*;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // ¿Qué queremos hacer?

        // 1.- Crear lista de enteros
        List<Integer> numeros = Superfunciones.proveer(10, new Proveedor<>() {
            final Random random = new Random();
            @Override
            public Integer obtener() {
                return random.nextInt(10);
            }
        });
        System.out.println(numeros);

        // 2.- Quedarme solo con los filtrados
        List<Integer> filtrados = Superfunciones.filtrar(numeros, new Predicado<>() {
            @Override
            public boolean test(Integer valor) {
                return valor % 2 == 0;
            }
        });
        System.out.println(filtrados);

        // 3a.- Obtener el cuadrado de cada número
        List<Integer> transformados = Superfunciones.transformar(filtrados, new OperadorUnario<>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        });
        System.out.println(transformados);

        // 3b.- Obtener cada número convertido en cadena
        List<String> convertidosEnCadena = Superfunciones.transformar(filtrados, new Funcion<Integer, String>() {
            @Override
            public String aplicar(Integer valor) {
                return "Valor: " + valor;
            }
        });
        System.out.println(convertidosEnCadena);

        // Puedo agregar a una variable la instancia de una Interfaz
        Consumidor<Integer> impresor = new Consumidor<>() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        };

        // 4a.- Mostrar cada cuadrado por pantalla y retorna lista
        List<Integer> actuados = Superfunciones.actuar(transformados, impresor);
        // 4b.- Mostrar cada cuadrado por pantalla y no retorna nada
        Superfunciones.consumir(transformados, impresor);

        // 5.- Obtener la suma de los transformados.
        Integer total = Superfunciones.reducir(actuados, 0, new OperadorBinario<>() {
            @Override
            public Integer aplicar(Integer val1, Integer val2) { return val1 + val2; }
        });
        System.out.println("Reducción: " + total);
    }
}
