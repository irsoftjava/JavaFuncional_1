package com.irsoft.funcional.v2_superfunciones_clases.clases;

import com.irsoft.funcional.v2_superfunciones_clases.interfaces.Proveedor;

import java.util.Random;

public class Aleatorio implements Proveedor {

    Random random = new Random();
    @Override
    public Integer obtener() {
        return random.nextInt(1000);
    }
}
