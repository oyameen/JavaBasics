package ComparatorAndComparable;

import java.util.*;

public class LaptopCompare {
    private static List<Laptop> getLaptops() {
        return Arrays.asList(
                new Laptop("HP", 15, 500),
                new Laptop("DELL", 32, 3482),
                new Laptop("ASUS", 15, 4253),
                new Laptop("APPLE", 20, 12556),
                new Laptop("MSI", 8, 5002)
        );
    }

    private static void printSeparator() {
        System.out.println();
        System.out.println("**********");
        System.out.println();
    }

    public static void main(String[] args) {

        /*
          Collections.sort(laptopList); without passing any Comparator it will throw an exception
          if Laptop Class not implements Comparable interface, so Laptop Class must implement
          Comparable interface in case no Comparator passed.

          if Laptop Class implements both Comparator and Comparable then
          Collections.sort(laptopList); without passing any Comparator it will consider Comparable implementation
          and if you add the Comparator as 2nd argument it will consider the Comparator implementation.

          Note: the Comparator passing can be done by creating new Laptop object if Laptop implements Comparator
          or by passing the Comparator as anonymous class for sort function.
         */

        List<Laptop> laptopList = getLaptops();
        System.out.println("Sorted laptops by RAM: ");
        Collections.sort(laptopList, new Laptop()); // OR laptopList.sort(new Laptop());
        laptopList.forEach(System.out::println);


        printSeparator();


        System.out.println("Sorted laptops by Brand ASCENDING ORDER: ");
        laptopList.sort((lap1, lap2) -> {
            if (lap1.getBrand().compareTo(lap2.getBrand()) > 0) {
                return 1;
            } else if (lap1.getBrand().compareTo(lap2.getBrand()) < 0) {
                return -1;
            }
            return 0;
        });
        laptopList.forEach(System.out::println);


        printSeparator();


        System.out.println("Sorted laptops by Brand DESCENDING ORDER: ");
        laptopList.sort(Comparator.comparing(Laptop::getBrand).reversed());
        laptopList.forEach(System.out::println);


        printSeparator();


        System.out.println("Sorted laptops by Price: ");
        Collections.sort(laptopList);
        laptopList.forEach(System.out::println);
    }
}
