package com.irsoft.funcional.v4_superfunciones_genericas;

import com.irsoft.funcional.v4_superfunciones_genericas.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Superfunciones {

    public static <T> List<T> filtrar(List<T> valores, Predicado<T>  predicado) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            if (predicado.test(valor)) resultado.add(valor);
        }
        return resultado;
    }

    public static <T> List<T> proveer(int size, Proveedor<T> proveedor) {
        List<T> resultado = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultado.add(proveedor.obtener());
        }
        return resultado;
    }

    public static <T, R> List<R> transformar(List<T> valores, Funcion<T, R> function) {
        List<R> resultado = new ArrayList<>();
        for (T valor : valores) {
            resultado.add(function.aplicar(valor));
        }
        return resultado;
    }

    public static <T> List<T> actuar(List<T> valores, Consumidor<T> consumidor) {
        for (T valor : valores) {
            consumidor.aceptar(valor);
        }
        return valores;
    }

    public static <T> void consumir(List<T> valores, Consumidor<T> consumidor) {
        for (T valor : valores) {
            consumidor.aceptar(valor);
        }
    }

    public static <T> T reducir(List<T> valores, T identidad, OperadorBinario<T> funcionBinaria) {
        T total = identidad;
        for (T valor : valores) {
            total = funcionBinaria.aplicar(total, valor);
        }
        return total;
    }
}
