package InnerClass;

public class AnonymousClass
{
    public static void main(String[] args)
    {
        //class
        FeaturePhone lFeaturePhone = new FeaturePhone()
        {
            public void show()
            {
                System.out.println("FeaturePhone Call ...");
            }
        };
        lFeaturePhone.show();
        ////
        //interface
        SmartPhone lSmartPhone = ()->System.out.println("SmartPhone Call ...");
        lSmartPhone.show();
    }
}
class FeaturePhone
{
    public void show()
    {
        System.out.println("XYZ ...");
    }
}


@FunctionalInterface    //you cannot add more than one method
interface SmartPhone
{
    void show();
    //void print();
}
