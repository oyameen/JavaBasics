package DependencyInjection;

public class DrawClass {
    private final Shape shape;

    public DrawClass(Shape shape) {
        this.shape = shape;
    }

    public void draw()
    {
        this.shape.draw();
    }
}

