package com.irsoft.funcional.v11_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
                // 2.- 0 o más operaciones intermedias.
                .filter(nombre -> nombre.contains("P"))
                // 3.- Operación terminal
                .forEach(System.out::println);

        List<String> result = nombres.stream()
                // 2.- 0 o más operaciones intermedias.
                .filter(nombre -> nombre.contains("P"))
                // 3.- Operación terminal
                .collect(Collectors.toList());

        List<String> nombres2 = Stream.of("Manolo", "Pedro", "Baldomero")
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(nombres2);

        List<Integer> respuesta = Stream.generate(() -> {
            int next = random.nextInt(10);
            System.out.printf("Se ha generado el %d%n", next);
            return next;
        }).limit(3).collect(Collectors.toList());
        System.out.println(respuesta);

        List<Integer> varios = Stream.iterate(1, valor -> valor < 1000, valor -> valor * 5)
                .collect(Collectors.toList());
        System.out.println(varios);

        List<Integer> valores = random.ints(6, 1, 50)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(valores);

        List<Integer> valores2 = IntStream.range(1, 50)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(valores2);

        System.out.println("Baldomero".chars().boxed().collect(Collectors.toList()));


    /**
     * En primer lugar tenemos una serie de métodos que permiten obtener un stream de un tipo primitivo a
     * partir de uno que no lo sea. Entre ellos tenemos mapToDouble(toDoubleFunction), que retorna un
     * DoubleStream correspondiente de aplicar a cada elemento del stream original la función de
     * conversión a double recibida. También tenemos métodos similares para otros tipos, como mapToInt()
     * o mapToLong().
     *
     * Si queremos realizar la conversión inversa, es decir, pasar por ejemplo un IntStream a un
     * Stream<Integer> podemos aplicar sobre el IntStream el método boxed() que retorna un stream similar
     * al anterior pero en el que el tipo de los elementos correspondiente al tipo boxed del tipo
     * primitivo correspondiente al stream original.
     *
     * El método principal de transformación es el método map(mapFunction), que retorna un nuevo stream
     * obtenido a partir de aplicar la función de transformación mapFunction indicada a cada uno de los
     * elementos del stream original. El tipo del stream resultante corresponderá al tipo de retorno de
     * la función de transformación, que puede ser distinto al tipo del stream original. El stream resultante
     * contendrá tantos elementos como el stream original.
     *
     */
        List<String> dobles = IntStream.range(1, 10)
                .boxed()
                .map(integer -> "V(" + integer + ", " + integer * 2 + ")")
                .collect(Collectors.toList());
        System.out.println(dobles);

        // Operacoines de transformación de stream
        List<Integer> resultado = Stream.of(2, 4, 6)
                .flatMap(valor -> getRandomNumbers(valor))
                .collect(Collectors.toList());

        System.out.println(resultado);

        // Operaciones individuales y de ordenación de Stream
        resultado = Stream.of(2, 4, 6)
                .peek(System.out::println)
                .collect(Collectors.toList());

        Stream.of(2, 4, 6).parallel()
                .forEachOrdered(System.out::println);

    }

    private Stream<Integer> getRandomNumbers(Integer sizes) {
        return random.ints(sizes, 1, 10).boxed();
    }


}
