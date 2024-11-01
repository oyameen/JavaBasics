package OOB;

public class InheritanceExample2
{
    public static void main(String[] args)
    {
        A lA = new A();
        lA.show();
        A lA1 = new B();
        lA1.show();
        A lA2 = new C();
        lA2.show();
        B lB = new B();
        lB.show();
        lB.display();

    }
}

class A
{
    public void show()
    {
        System.out.println("in A show");
    }
}
class B extends A
{
    public void show()
    {
        System.out.println("in B show");
    }

    public void display()
    {
        System.out.println("in B display");
    }
}
class C extends A
{
    public void show()
    {
        System.out.println("in C show");
    }

    public void display()
    {
        System.out.println("in C display");
    }
}
