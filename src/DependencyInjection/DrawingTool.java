package DependencyInjection;

public class DrawingTool {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        DrawClass drawClass = new DrawClass(rectangle);
        drawClass.draw();
        drawClass = new DrawClass(circle);
        drawClass.draw();

    }
}
