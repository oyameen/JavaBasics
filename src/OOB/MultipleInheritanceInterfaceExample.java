package OOB;

public class MultipleInheritanceInterfaceExample
{
    public static void main(String[] args)
    {
        X_FeaturedAC lXFeaturedAC = new X_FeaturedAC();
        lXFeaturedAC.runAC();
        lXFeaturedAC.show();
        lXFeaturedAC.sendNotification();
        ////
        Y_SmartAC lYSmartAC = new Y_SmartAC();
        lYSmartAC.runAC();
        lYSmartAC.show();
        lYSmartAC.sendNotification();
        ////
        System.out.println("***");
        ////
        LgAC lLgAC = new Y_SmartAC();
        lLgAC.show();
        ////
        SamsungAC lSamsungAC = new Y_SmartAC();
        lSamsungAC.sendNotification();
        ////
        MediaAC lMediaAC = new X_FeaturedAC();
        lMediaAC.runAC();
    }
}
interface LgAC
{
    void runAC();
    default void show()
    {
        System.out.println("in LG AC");
    }
}
interface SamsungAC
{
    void runAC();

    default void show()
    {
        System.out.println("in Samsung AC");
    }
    default void sendNotification()
    {
        System.out.println("Samsung send Notification start ...");
    }
}

interface MediaAC
{
    void runAC();
    default void show()
    {
        System.out.println("in Media AC");
    }
}

abstract class FeaturedAC implements LgAC,SamsungAC,MediaAC
{

    @Override
    public void runAC()
    {
        System.out.println("Featured AC Run start ...");
    }

    @Override
    public void show()
    {
        LgAC.super.show();
    }
}

class X_FeaturedAC extends FeaturedAC implements LgAC,SamsungAC,MediaAC
{
    @Override
    public void show()
    {
        System.out.println("in X_FeaturedAC show ...");
    }
}

class SmartAC implements LgAC,SamsungAC,MediaAC
{

    @Override
    public void runAC()
    {
        System.out.println("Smart AC Run start ...");
    }

    @Override
    public void show()
    {
        SamsungAC.super.show();
    }
}
class Y_SmartAC extends SmartAC implements LgAC,SamsungAC,MediaAC
{
    @Override
    public void show()
    {
        System.out.println("in Y_SmartAC show ...");
    }
}