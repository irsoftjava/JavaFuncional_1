package com.irsoft.funcional.v2_superfunciones_clases.clases;

import com.irsoft.funcional.v2_superfunciones_clases.interfaces.FuncionBinaria;

public class Sumador implements FuncionBinaria {

    @Override
    public Integer aplicar(Integer val1, Integer val2) {
        return val1 + val2;
    }
}
