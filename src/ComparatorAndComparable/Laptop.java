package ComparatorAndComparable;

import java.util.Comparator;

public class Laptop implements Comparator<Laptop>,Comparable<Laptop>{
    private String brand;
    private int ram;
    private int price;

    public Laptop() {
    }

    public Laptop(String brand, int ram, int price) {
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Laptop laptop) {
        if(getPrice()>laptop.getPrice())
            return 1;
        else if(getPrice()<laptop.getPrice())
            return -1;
        return 0;
    }

    @Override
    public int compare(Laptop lap1, Laptop lap2) {
        if (lap1.getRam() > lap2.getRam())
            return 1;
        else if (lap1.getRam() < lap2.getRam()) {
            return -1;
        }
        return 0;
    }
}