package com.irsoft.funcional.v11_streams;

import java.util.*;
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

        /**
         * Ordenación:
         *
         * Algunos stream son ordenados, es decir que sus elementos poseen un determinado orden intrínseco
         * significativo, conocido como (encounter order). Por ejempplo, un stream cuya fuente de datos
         * corresponda a una lista creará un stream ordenado, cuyo encounter order será el orden en el que los
         * elementos están situados en la lista. Sin embargo, otros stream no son ordenados, en el sentido de
         * que sus elementos no tienen un orden intrínseco significativo. Por ejemplo, un stream cuya fuente
         * de datos sea un conjunto (set) será un stream sin encounter order, ya que en un conjunto los elementos
         * no tienen un orden preestablecido.
         *
         * El hecho de que un stream sea ordenado o no dependerá del tipo de fuente de datos asociada y de las
         * operaciones intermedias anteriores que hayamos realizado mediante las que se han obtenido el stream.
         *
         * Algunas operaciones trabajan por defecto en base a este encounter order, imponiendo una restrinción
         * acerca del orden en el qe los elementos deben ser procesados, como por ejemplo las operaciones
         * intermedias limit() o skip(). Por ejemplo:
         *
         *          Stream.of("Baldomero", "Germán Ginés", "Ambrosio")
         *                .limit(2)
         *                .forEach(System.out::println);
         *
         * muestra los valores Baldomero y Germán Ginés.
         */
        Stream.of(2, 4, 6).parallel()
                .forEachOrdered(System.out::println);

        Stream.of(2, 6, 4)
                .sorted(Comparator.reverseOrder())
                .forEachOrdered(System.out::println);

        /**
         * Métodos simples de reducción de streams
         *
         * La clase Stream y las clases específicas DoubleStream, IntStream y LongStream
         * implementan algunos métodos que son operaciones terminales de reducción especializadas.
         *
         * La primera de ellas es count(), que retorna un long con el número de elementos de un Stream.
         *
         * long cuantosSonPares = Stream.of(1, 2, 3)
         *              .filter(n -> n % 2 == 0)
         *              .count();
         *
         * retorna 1, ya que despues de filtrar el Stream para quedarnos solo con los números pares
         * tan solo queda uno.
         *
         * Las clases DoubleStream, IntStream y LongStream, correspondientes a streams de elementos
         * de tipo primitivos numéricos, disponen del método sum() para calcular la suma de los
         * elementos del Stream.
         */

        int resultInt = IntStream.range(1, 10)
                .sum();

        int resultInt2 = Stream.of(1, 2, 3)
                .mapToInt(v -> v.intValue())
                .sum();

        long resultInt3 = Stream.of(1, 2, 3)
                .count();

        System.out.printf("%d, %d, %d%n", resultInt, resultInt2, resultInt3);

        /**
         * Estas clases de Streams de elementos de tipo pimitivo numérico también disponen de
         * métodos para obtener el valor máximo, max(), el valor mínimo, min() y la media
         * aritmética, average(), de los elementos numéricos del Stream. Dado que el Stream
         * sobre el que se apliquen puede estar vacío, estos métodos retornan un Optional, es
         * decir, un valor opcional del tipo correspondiente.
         *
         * OptionalDouble maxImpares = IntStream.of(1, 2, 3)
         *      .filter(n -> n % 2 != 0)
         *      .max();
         *
         * OptionalDouble maxImpares = IntStream.of(1, 2, 3)
         *      .filter(n -> n % 2 != 0)
         *      .min();
         *
         * OptionalDouble maxImpares = IntStream.of(1, 2, 3)
         *      .filter(n -> n % 2 != 0)
         *      .average();
         */


        OptionalInt respInt = Stream.of(1, 2, 3)
                        .mapToInt(Integer::intValue)
                        .max();

        OptionalInt respInt2 = Stream.of(1, 2, 3)
                .mapToInt(Integer::intValue)
                .min();

        OptionalDouble respInt3 = Stream.of(1, 2, 3)
                .mapToInt(Integer::intValue)
                .average();


    }

    private Stream<Integer> getRandomNumbers(Integer sizes) {
        return random.ints(sizes, 1, 10).boxed();
    }


}
