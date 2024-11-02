package Serialization;

import java.io.*;

/*
 * When SupperClass implement the serializable interface and ChildClass extends SupperClass,
 * and ChildClass Override write/read Object by throwing @{@link NotSerializableException}
 * then Serialization process cannot happen and will throw that exception in writeObject
 * when write the object, and in readObject when read it.
 */
abstract class SupperClass3 implements Serializable
{
    int i;
    transient int x;
    SupperClass3(int i,int x)
    {
        this.i = i;
        this.x = x;
    }

    @Override
    public String toString() {
        return "SupperClass3{" +
                "i=" + i +
                ", x=" + x +
                '}';
    }

}
class ChildClass3 extends SupperClass3
{
    int j;
    transient int y;
    ChildClass3(int i,int x, int j, int y)
    {
        super(i,x);
        this.j = j;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ChildClass3{" +
                "j=" + j +
                ", y=" + y +
                "} " + super.toString();
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        throw new NotSerializableException();
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException
    {
        throw new NotSerializableException();
    }
}
public class SerializableInheritance3 {
    public static void main(String[] args) throws Exception {
        ChildClass3 childClass3_1 = new ChildClass3(20,25,30,35);
        System.out.println(childClass3_1);
        File file = new File("SerializableInheritance3.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(childClass3_1);
        oos.close();
        fos.close();

        System.out.println("ChildClass3 Object has been serialized.");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ChildClass3 childClass3_2 = (ChildClass3) ois.readObject();
        ois.close();
        fis.close();

        System.out.println("ChildClass3 Object has been deserialized.");
        System.out.println(childClass3_2);

    }
}
