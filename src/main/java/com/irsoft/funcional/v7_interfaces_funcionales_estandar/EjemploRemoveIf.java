package com.irsoft.funcional.v7_interfaces_funcionales_estandar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploRemoveIf {

    public static void main(String[] args) {

        List<String> alumnos = new ArrayList<>(Arrays.asList(
                "Baldomero", "German", "Ernesto", "Ginés", "Antonio", "Godofreno"
        ));

        System.out.printf("Alumnos: %s\n", String.join(", ", alumnos));
        alumnos.removeIf(alumno -> alumno.contains("G"));
        System.out.printf("Alumnos sin G: %s\n", String.join(", ", alumnos));
    }
}
