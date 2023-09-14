package com.irsoft.funcional.v2_superfunciones_clases;

import com.irsoft.funcional.v2_superfunciones_clases.interfaces.Predicado;
import com.irsoft.funcional.v2_superfunciones_clases.interfaces.Proveedor;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

public class Superfunciones {

    public static List<Integer> filtrar(List<Integer> valores, Predicado predicado) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer valor : valores) {
            if (predicado.test(valor)) resultado.add(valor);
        }
        return resultado;
    }

    public static List<Integer> proveer(int size, Proveedor proveedor) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultado.add(proveedor.obtener());
        }
        return resultado;
    }
}
