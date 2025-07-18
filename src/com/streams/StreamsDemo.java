package com.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {

        // 1. Print sum of all numbers
        List<Integer> intList = Arrays.asList(1,2982,2,243,243,30,3,4,4);
        int sum = intList.stream().reduce((a,b) -> (a + b)).get();
        System.out.println(sum);

        int sum1 = intList.stream().mapToInt(Integer :: valueOf).sum();
        System.out.println(sum1);

        // 2. Average of all number
        double average = intList.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println(average);

        // 3. find the average of square of each number which are greater that 10
        double average1 = intList.stream()
                                .map(e -> e*e)
                                .filter(e -> e > 10)
                                .mapToInt(e -> e).average().getAsDouble();
        System.out.println(average1);

        // 4. Even and odd numbers
        List<Integer> evenNumbers = intList.stream()
                                            .filter(e -> e%2 == 0)
                                                .toList();
        System.out.println(evenNumbers);

        // 5. Print numbers start with prefix 2
        List<Integer> prefix2 = intList.stream()
                                            .map(e -> String.valueOf(e))
                                                .filter(e -> e.startsWith("2"))
                                                    .map(Integer :: valueOf).toList();
        System.out.println(prefix2);

        // 6. Print duplicate numbers
        List<Integer> duplicateNumbers = intList.stream()
                                                    .filter(e -> Collections.frequency(intList, e) > 1).toList();
        System.out.println(duplicateNumbers);

        // 7. print duplicate numbers but only once
        Set<Integer> duplicateNumbers1 = intList.stream()
                                                    .filter(e -> Collections.frequency(intList, e) > 1)
                                                        .collect(Collectors.toSet());
        System.out.println(duplicateNumbers1);

        // 8. Find max and min number
        int max = intList.stream().max(Comparator.comparing(Integer :: valueOf)).get();
        int min = intList.stream().min(Comparator.comparing(Integer :: valueOf)).get();

        System.out.println(min + " and " + max);

        // 9. Sorting asc/desc
        List<Integer> ascSorted = intList.stream().sorted().collect(Collectors.toList());
        List<Integer> descSorted = intList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(ascSorted);
        System.out.println(descSorted);

        // 10 get ignore or skip n number of elements
        List<Integer> list3 = intList.stream().limit(3).collect(Collectors.toList());
        int sum3 = intList.stream().limit(3).reduce((a, b) -> (a + b)).get();
        int sum2 = intList.stream().skip(3).reduce((a, b) -> (a + b)).get();

        System.out.println(list3 + ", " + sum3 + ", " + sum2);

        // 11. Second highest and lowest number
        int secondHighest = intList.stream().sorted(Collections.reverseOrder()).limit(3).skip(2).findFirst().get();
        System.out.println(intList);
        System.out.println(secondHighest);
    }
}
