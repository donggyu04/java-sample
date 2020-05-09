package com.training.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;
import static java.lang.Math.pow;

/**
 * Any interface with a SAM(Single Abstract Method) is a functional interface.
 */
public class Main {
    public static void main(String[] args) {

        // Function interface use case.
        // public interface Function<T, R> { … }
        Map<String, Integer> nameMap = new HashMap<>();
        // s -> s.length == String:length (method reference)
        Integer value = nameMap.computeIfAbsent("John", String::length);


        // BiFunction use case.
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) ->
                name.equals("Freddy") ? oldValue : oldValue + 10000);

        System.out.println(salaries);

        // Supplier, lazy square.
        Supplier<Double> lazyValue = () -> {
            sleepUninterruptibly(3, TimeUnit.SECONDS);
            return 9d;
        };

        System.out.println("Calculation will be execute after 3 sec");
        System.out.println(square(lazyValue));

        int[] fibs = {0, 1};
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        }).limit(10);
        fibonacci.forEach(System.out::println);

        // Consumer
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name));

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);

        // BiConsumer
        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

        // predicate
        List<String> students = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
        List<String> namesWithA = students.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(namesWithA);

        // Operators

        // UnaryOperator
        List<String> person = Arrays.asList("bob", "josh", "megan");
        person.replaceAll(String::toUpperCase);

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        // BinaryOperator
        int sum = values.stream()
                .reduce(1000, Integer::sum);
        System.out.println(sum);

    }

    byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.apply(array[i]);
        }
        return transformedArray;
    }

    public static double square(Supplier<Double> lazyValue) {
        return pow(lazyValue.get(), 2);
    }

}

