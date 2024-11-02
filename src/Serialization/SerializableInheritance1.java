package Serialization;

import java.io.*;

/*
 * When SupperClass implement the serializable interface and ChildClass extends SupperClass,
 * then ChildClass also support it by default.
 */
class SupperClass1 implements Serializable
{
    int i;
    transient int x;
    /*
     * Note static field will be ignored during the serialization similar to transient
     */
    static int z = 100;
    SupperClass1(int i,int x)
    {
        this.i = i;
        this.x = x;
    }

    @Override
    public String toString() {
        return "SupperClass1{" +
                "i=" + i +
                ", x=" + x +
                ", z=" + z +
                '}';
    }
}
class ChildClass1 extends SupperClass1
{
    int j;
    transient int y;
    ChildClass1(int i,int x, int j, int y)
    {
        super(i,x);
        this.j = j;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ChildClass1{" +
                "j=" + j +
                ", y=" + y +
                "} " + super.toString();
    }
}
public class SerializableInheritance1 {
    public static void main(String[] args) throws Exception {
        ChildClass1 childClass1_1 = new ChildClass1(20,25,30,35);
        System.out.println(childClass1_1);
        File file = new File("SerializableInheritance1.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(childClass1_1);
        oos.close();
        fos.close();

        System.out.println("ChildClass1 Object has been serialized.");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ChildClass1 childClass1_2 = (ChildClass1) ois.readObject();
        ois.close();
        fis.close();

        System.out.println("ChildClass1 Object has been deserialized.");
        System.out.println(childClass1_2);

    }
}

