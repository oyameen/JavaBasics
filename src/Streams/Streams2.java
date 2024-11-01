package Streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.*;

public class Streams2 {
    private static void printSeparator()
    {
        System.out.println();
        System.out.println("**********");
        System.out.println();
    }
    public static void main(String[] args) {
        IntStream
                .range(1,8)
                .forEach(System.out::print);
        System.out.println();

        printSeparator();

        IntStream
                .range(1,8)
                .skip(4)
                .forEach(System.out::print);
        System.out.println();

        printSeparator();

        System.out.println(IntStream
                .range(1,8)
                .sum());

        printSeparator();

        Stream.of("AB","AA", "AC")
                .sorted()
                .findFirst().ifPresent(System.out::println);

        printSeparator();

        String [] names = {"AAA","BBB","SR","C","D","SA","E","ST","F","SB","G","H"};
        Arrays.stream(names)
                .filter(name-> name.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        printSeparator();

        Arrays.stream(new int[]{7,5,2,9,3})
                .map(i -> i*i)
                .average()
                .ifPresent(System.out::println);

        printSeparator();

        Arrays.stream(names).map(String::toLowerCase).filter(name->name.startsWith("s")).forEach(System.out::println);

        printSeparator();

        Arrays.stream(names).sorted().filter(name->name.length()>2).forEach(System.out::println);

        printSeparator();

        double total = Stream.of(8.5,2.5,6.3).reduce(0.0,(a,b)->a+b);
        System.out.println(total);

        printSeparator();

        total = Stream.of(8.5,2.5,6.3).reduce(0.0, Double::sum);
        System.out.println(total);

        printSeparator();

        IntSummaryStatistics summary = IntStream.of(26,43,95,10,45,95,55,53,67).summaryStatistics();
        System.out.println(summary);
    }


}
