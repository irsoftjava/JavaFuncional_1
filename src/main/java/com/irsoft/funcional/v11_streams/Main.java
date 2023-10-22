package com.irsoft.funcional.v11_streams;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    Random random = new Random();

    public static void main(String[] args) {
        new Main();
    }

    /**
     * Constructor de Main
     */
    public Main() {

//        Integer maximo = Flujo.proveer(10, this::randomInt)
//                //.filtrar(NumbersUtils::esPrimo)
//                .filtrar(valor -> valor >= 10)
//                //.ordenar((valor1, valor2) -> valor1 - valor2)
//                .ordenar(Integer::compareTo)
//                .transformar(NumbersUtils::elevarAlCuadrado)
//                //.transformar(valor -> new Descripcion(valor))
//                .transformar(Descripcion::new)
//                .actuar(System.out::println)
//                //.transformar(description -> description.getValue())
//                .transformar(Descripcion::getValue)
//                //.reducir(0, Integer::sum);
//                // De menor a mayor
//                //.max((valor1, valor2) -> valor1 - valor2)
//                //.max(Integer::compare)
//                // Orden inverso
//                //.max(Comparator.reverseOrder())
//                .max(Comparator.naturalOrder());

//        double maxDouble = maximo.doubleValue();
//        System.out.println("Máximo: " + maxDouble);


        /**
         * Streams:
         *
         * Un Stream (flujo) en Java es una secuencia de elementos que se puede procesar (mapear, filtrar,
         * transformar, reducir, recolectar), de forma secuencial o paralela, mediante una cadena de
         * operaciones especificadas a través de expresiones lambdas. Introducidos en Java 8, los 'stremas'
         * permiten optimizar la forma de procesar grandes colecciones de datos.
         *
         * La interfaz (Stream[T]) representa un flujo de elementos de tipo T, aunque también se definen
         * interfaces concretas para los tipos primitivos, como IntStream, LongStream, etc.
         *
         * Un Stream es una abstracción que representa un flujo de datos, pero NO una estructura de datos, ya
         * que los elementos NO son almacenados en el Stream, sino tan solo procesados por él. De hecho, NO
         * se pueden acceder individualmente a un determinado elemento del Stream, sino que se define la fuente
         * de datos de origen del stream y la secuencia de operaciones que se debe aplicar sobre sus elementos,
         * especificadas de forma funcional mediante expresiones lambdas.
         *
         * Más aún, la fuente de datos origen del stream NO se ve afectada por las operaciones realizadas a
         * partir de él dentro del stream. Por ejemplo, si se filtran algunos elementos de datos del stream, NO
         * se eliminan realmente de a fuente de datos origen, simplemente se omiten a partir de ese momento
         * y ya no se tienen en cuenta en la siguiente operación incluida en la secuencia de operaciones del stream.
         *
         * Por tanto, los datos con los que trabajamos no se ven afectados por el stream.
         *
         * Los Stream solo gestionan datos transitorios en memoria, lo que implica que si la aplicación falla
         * dichos datos se perderán.
         *
         * Un stream puede ser finito, es decir, tener un número finito de elementos, o infinitos, si genera un
         * número infinito de elementos. Algunas operaciones permiten restringir el número de elementos
         * procesados, como limit() o findFirst().
         */

        /**
         * Pipeline:
         *
         * Una vez hayamos creado un stream a partir de una fuente de datos, podremos ejecutar sobre él
         * cero o más operaciones intermedias y, forzosamente, una operación final. A esta cadena de operaciones
         * se les conoce como pipeline, y es el equivalente a una expresión matemática del tipo h(g(f(x))).
         * Por tanto, un pipeline tiene los siguientes elementos en el siguiente orden:
         *
         *      - Una función generadora de stream.
         *      - Cero o más operaciones intermedias.
         *      - Una operación terminal.
         *
         * Debemos tener en cuenta que cada operación intermedia del pipeline genera un nuevo stream
         * resultante de aplicar la operación indicada al stream anterior de la cadena. Por ejemplo, si tenemos
         * el siguiente pipeline:
         *
         *          IntStream.range(1, 8)
         *                  .filter(n -> n % 2 == 0)
         *                  .forEach(System.out::println);
         *
         * El método estático range() retorna un stream que es usado por el método filter() que retorna
         * un nuevo stream que es usado por el método forEach().
         */

        ArrayList<String> nombres = new ArrayList<>(List.of("Manolo", "Pedro", "Baldomero"));

        // 1.- Función generadora del Stream
        nombres.stream()
                // 2.- 0 o más operaciones intemedias.
                .filter(nombre -> nombre.contains("P"))
                // 3.- Operación terminal
                .forEach(System.out::println);
    }

    private Integer randomInt() {
        return random.nextInt(10);
    }
}
