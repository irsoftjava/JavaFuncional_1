package com.irsoft.funcional.v6_lambdas.interfaces;
@FunctionalInterface
public interface FuncionBinaria<T, U, R> {

    R aplicar(T val1, U val2);
}
