package DependencyInjection;

public abstract class Shape {
    public abstract void draw();
}

class Rectangle extends Shape {

    public void draw() {
        System.out.println(" ====> Rectangle drawing.");
    }
}

class Circle extends Shape {

    public void draw() {
        System.out.println(" ====> Circle drawing.");
    }
}
