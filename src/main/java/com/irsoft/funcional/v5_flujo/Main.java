package com.irsoft.funcional.v5_flujo;

import com.irsoft.funcional.v5_flujo.interfaces.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        Integer total =
                Flujo.proveer(10, new Proveedor<Integer>() {
                    final Random random = new Random();
                    @Override
                    public Integer obtener() {
                        return random.nextInt(100);
                    }
                }).filtrar(new Predicado<>() {
                    @Override
                    public boolean test(Integer valor) {
                        return valor % 2 == 0;
                    }
                }).transformar(new OperadorUnario<>() {
                    @Override
                    public Integer aplicar(Integer valor) {
                        return valor * valor;
                    }
                }).actuar(new Consumidor<>() {
                    @Override
                    public void aceptar(Integer valor) {
                        System.out.println(valor);
                    }
                }).reducir(0, new OperadorBinario<>() {
                    @Override
                    public Integer aplicar(Integer val1, Integer val2) { return val1 + val2; }
                });

        System.out.println("Reducción: " + total);
    }
}
