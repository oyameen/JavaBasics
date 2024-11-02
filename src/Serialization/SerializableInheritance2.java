package Serialization;

import java.io.*;
/*
 * When ChildClass implement the serializable interface and SupperClass not,
 * then ChildClass only support serialization and SupperClass no.
 */
class SupperClass2{
    int i;
    transient int x;
    SupperClass2(int i,int x)
    {
        this.i = i;
        this.x = x;
    }
    SupperClass2()
    {
        /*
         * Note that when ChildClass extends SupperClass and the implementation
         * of Serializable done on ChileClass then the Default SupperClass Constructor MUST be existed, else Exception raised.
         * and any value you provide for the variable like bellow will be populated in result.
         * if the variable not provided the result will be the default value for the variables.
         * Note in this case only ChildClass support the serialization and SupperClass No.
         */

        /*
        i=60;
        x=70;
        */
        System.out.println("SupperClass2 constructor called.");
    }
    @Override
    public String toString() {
        return "SupperClass2{" +
                "i=" + i +
                ", x=" + x +
                '}';
    }
}
class ChildClass2 extends SupperClass2 implements Serializable
{
    int j;
    transient int y;
    ChildClass2(int i,int x, int j, int y)
    {
        super(i,x);
        this.j = j;
        this.y = y;
    }


    @Override
    public String toString() {
        return "ChildClass2{" +
                "j=" + j +
                ", y=" + y +
                "} " + super.toString();
    }
}
public class SerializableInheritance2 {

    public static void main(String[] args) throws Exception {
        ChildClass2 childClass2_1 = new ChildClass2(20, 25, 30, 35);
        System.out.println(childClass2_1);
        File file = new File("SerializableInheritance2.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(childClass2_1);
        oos.close();
        fos.close();

        System.out.println("ChildClass2 Object has been serialized.");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ChildClass2 childClass2_2 = (ChildClass2) ois.readObject();
        ois.close();
        fis.close();

        System.out.println("ChildClass2 Object has been deserialized.");
        System.out.println(childClass2_2);
    }
}
