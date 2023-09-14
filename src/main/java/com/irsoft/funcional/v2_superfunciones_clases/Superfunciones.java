package com.irsoft.funcional.v2_superfunciones_clases;

import com.irsoft.funcional.v2_superfunciones_clases.interfaces.Predicado;
import java.util.ArrayList;
import java.util.List;

public class Superfunciones {

    public static List<Integer> filtrar(List<Integer> valores, Predicado predicado) {
        List<Integer> resultado = new ArrayList<Integer>();
        for (Integer valor : valores) {
            if (predicado.test(valor)) resultado.add(valor);
        }
        return resultado;
    }
}
