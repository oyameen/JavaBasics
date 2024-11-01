import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test {

    private String str;

    public Test() {
        str = "dummyText";
    }

    public void method1() {
        System.out.println("The string is " + str);
    }

    public void method2(int n) {
        System.out.println("The number is " + n);
    }

    private void method3() {
        System.out.println("Private method invoked.");
    }
}

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Test obj = new Test();
        Class<? extends Test> cls = obj.getClass();
        System.out.println("The name of class is " + cls.getName());
        Constructor<? extends Test> constructor = cls.getConstructor();
        System.out.println("The name of constructor is " + constructor.getName());

        ////

        System.out.println("The public methods of class are : ");
        Method[] methods = cls.getMethods();
        for (Method method : methods)
            System.out.println(method.getName());

        ////

        Field field = cls.getDeclaredField("str");
        field.setAccessible(true);
        System.out.println("set s to JAVA");
        field.set(obj, "JAVA");

        ////

        Method method1Call = cls.getDeclaredMethod("method1");
        System.out.println("invoke method 1");
        method1Call.invoke(obj);

        ////

        Method method2Call = cls.getDeclaredMethod("method2", int.class);
        System.out.println("invoke method 2");
        method2Call.invoke(obj, 19);

        ////

        Method method3Call = cls.getDeclaredMethod("method3");
        method3Call.setAccessible(true);
        System.out.println("invoke method 3");
        method3Call.invoke(obj);
    }
}
