package InnerClass;

public class MemberClass
{
    public static void main(String[] args)
    {
        OuterClass lOuterClass = new OuterClass();
        OuterClass.InnerClass lInnerClass = lOuterClass.new InnerClass();
        lInnerClass.j = 5;
        lInnerClass.printJ();
    }
}
class OuterClass
{
    int i;
    class InnerClass
    {
        int j;
        public void printJ()
        {
            System.out.println("j value : " + j);
        }
    }
}
