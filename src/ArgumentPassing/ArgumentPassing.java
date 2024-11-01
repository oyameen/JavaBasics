package ArgumentPassing;

class Demo {
    public int value;
}

public class ArgumentPassing {

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.value = 5;

        f(demo);

        System.out.println(demo.value);//   5
    }

    static void f(Demo demo) {

        demo = new Demo();
        demo.value = 8;
    }
}
