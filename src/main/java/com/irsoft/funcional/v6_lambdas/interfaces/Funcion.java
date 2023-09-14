package com.irsoft.funcional.v6_lambdas.interfaces;
@FunctionalInterface
public interface Funcion<T, R> {

    R aplicar(T valor);
}
