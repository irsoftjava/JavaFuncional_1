package com.irsoft.funcional.v2_superfunciones_clases.clases;

import com.irsoft.funcional.v2_superfunciones_clases.interfaces.Predicado;

public class SoloImpares implements Predicado {
    @Override
    public boolean test(Integer valor) {
        return valor % 2 != 0;
    }
}
