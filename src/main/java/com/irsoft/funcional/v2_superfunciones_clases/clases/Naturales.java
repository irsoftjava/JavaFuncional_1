package com.irsoft.funcional.v2_superfunciones_clases.clases;

import com.irsoft.funcional.v2_superfunciones_clases.interfaces.Proveedor;

public class Naturales implements Proveedor {

    private static int next = 0;

    @Override
    public Integer obtener() { return next++; }
}
