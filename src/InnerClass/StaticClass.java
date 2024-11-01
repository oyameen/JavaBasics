package InnerClass;

public class StaticClass
{
    public static void main(String[] args)
    {

        A.B lB = new A.B();
        lB.j = 5;
        lB.printJ();
    }
}
class A
{
    int i;
    static class B
    {
        int j;
        public void printJ()
        {
            System.out.println("j value : " + j);
        }
    }
}