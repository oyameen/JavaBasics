package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum Laptop{
    DELL,HP,MSI,ASUS
}
class Person{
    private String name;
    private int age;
    private Laptop laptop;

    public Person(String name, int age, Laptop laptop) {
        this.name = name;
        this.age = age;
        this.laptop = laptop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", laptop=" + laptop +
                '}';
    }

}

public class Streams1 {
    private static List<Person> getPerson() {
        return List.of(
                new Person("AA", 22, Laptop.ASUS),
                new Person("BB", 24, Laptop.MSI),
                new Person("C", 120, Laptop.DELL),
                new Person("D", 42, Laptop.HP),
                new Person("E", 54, Laptop.DELL),
                new Person("F", 35, Laptop.MSI),
                new Person("G", 66, Laptop.ASUS),
                new Person("H", 75, Laptop.MSI),
                new Person("I", 14, Laptop.DELL),
                new Person("J", 40, Laptop.DELL)

        );
    }
    private static void printSeparator()
    {
        System.out.println();
        System.out.println("**********");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Person> people = getPerson();

        System.out.println("All person have DELL Laptop.");
        List<Person> allDellLaptopPerson = people.stream().filter(person -> person.getLaptop().equals(Laptop.DELL)).toList();
        allDellLaptopPerson.forEach(System.out::println);

        printSeparator();

        System.out.println("Sort person by age.");
        List<Person> sortedByAge = people.stream().sorted(Comparator.comparing(Person::getAge)).toList();
        sortedByAge.forEach(System.out::println);

        printSeparator();

        System.out.println("All MSI Laptop Match.");
        boolean allMSIMatch=people.stream()
                .allMatch(person -> person.getLaptop().equals(Laptop.MSI));
        System.out.println("All match with MSI Laptop ==> " + allMSIMatch);

        printSeparator();

        System.out.println("any Age > 54 Match.");
        boolean anyAgeMoreThan54Match=people.stream()
                .anyMatch(person -> person.getAge()>54);
        System.out.println("Any match with age > 54  ==> "+anyAgeMoreThan54Match);

        printSeparator();

        System.out.println("None age > 54 Match.");
        boolean noneAgeMoreThan54Match = people.stream()
                .noneMatch(person -> person.getAge()>54);
        System.out.println("None match with age >54  ==> "+noneAgeMoreThan54Match);

        printSeparator();


        System.out.println("Max name.");
        people.stream()
                .max(Comparator.comparing(Person::getName))
                .ifPresent(System.out::println);

        printSeparator();


        System.out.println("Oldest person");
        people.stream()
                .min(Comparator.comparing(Person::getAge).reversed())
                .ifPresent(System.out::println);

        printSeparator();


        System.out.println("GroupByLaptopType");
        Map<Laptop,List<Person>> groupByLaptopType =people.stream()
                .collect(Collectors.groupingBy(Person::getLaptop));

        groupByLaptopType.forEach((g,p)->
                {
                    System.out.println(g);
                    p.forEach(System.out::println);

                }
        );

        printSeparator();

    }
}
