package Interfaces;


interface I_Interface {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// Note there is no meaning of no access modifier here as it considered as public without mention it. ////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// interface variable always they public static final. ///////////////////////////////////////////////////////////
    //// in case of using others modifiers likes private, protected, no access modifier will throw compilation error. //
    //// Note that Interface variable have same role of public static method, so if you implement more than one ////////
    //// interface have same variable name then will be there a diamond conflict, so solution is to use Interface //////
    //// name to determine which one you mean, or you need to use. /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int i = 0;
    int x = 1;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// you can declare private (normal or static) method inside the interface. ///////////////////////////////////////
    //// Note private method must have body declaration. ///////////////////////////////////////////////////////////////
    //// Note private method can only be static or non-static. /////////////////////////////////////////////////////////
    //// Note private method cannot have final keyword. ////////////////////////////////////////////////////////////////
    //// Note private method must have a body declaration else compile time error. /////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void normalInit() {
        System.out.println("normalInit method of I_Interface invoked.");
    }

    private static void staticInit() {
        System.out.println("staticInit method of I_Interface invoked.");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// you can declare a public static methods in interface. /////////////////////////////////////////////////////////
    //// Note public static method must have body declaration. /////////////////////////////////////////////////////////
    //// Note it invoked by interface name directly similar to static class method. ////////////////////////////////////
    //// Note public static method cannot have final keyword. //////////////////////////////////////////////////////////
    //// Note public static method must have a body declaration else compile time error. ///////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static void show() {
        staticInit();
        System.out.println("show method of I_Interface invoked.");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// you can declare public default method in interface. ///////////////////////////////////////////////////////////
    //// Note public default method must have body declaration. ////////////////////////////////////////////////////////
    //// Note public default method cannot have final keyword. /////////////////////////////////////////////////////////
    //// Note public default  method must have a body declaration else compile time error. /////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    default void display() {
        normalInit();
        staticInit();
        System.out.println("display method of I_Interface invoked with x = " + x);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// The default modifier for interface method is public abstract not-static. //////////////////////////////////////
    //// Note interface methods must not have a declaration body. //////////////////////////////////////////////////////
    //// Note it should be overridden in the class implements the interface. ///////////////////////////////////////////
    //// Note interface methods method cannot have final keyword. //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void print();

    void run();


}

interface J_Interface {
    int x = 2;

    private void normalInit() {
        System.out.println("normalInit method of J_Interface invoked.");
    }

    private static void staticInit() {
        System.out.println("staticInit method of J_Interface invoked.");
    }

    static void show() {
        staticInit();
        System.out.println("show method of J_Interface invoked.");
    }

    default void display() {
        normalInit();
        staticInit();
        System.out.println("display method of J_Interface invoked with x = " + x);

    }

    void print();
}

class C1_Class implements I_Interface, J_Interface {
    int x = 4;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// Note that when implements multiple interfaces contains same method, then the class the implements /////////////
    //// those interfaces must override them else compilation error because java cannot solve the conflict /////////////
    //// raised by Diamond problem. ////////////////////////////////////////////////////////////////////////////////////
    //// Note this applicable on methods that is (default or public abstract non-static) methods that have same ////////
    //// signature between the implemented interfaces. /////////////////////////////////////////////////////////////////
    //// Note that the override of public static method is not allowed and will throw compilation time error. Static ///
    //// methods cannot be annotated with @Override, but you can have same public static signature without @Override ///
    //// to invoke it by the Class reference name directly. ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void display() {
        I_Interface.super.display(); //This works with (public default and static) methods

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void show() {
        System.out.println("show method of C1_Class invoked.");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void print() {
        System.out.println("print method of C1_Class invoked.");
    }

    @Override
    public void run() {
        System.out.println("run method of C1_Class invoked.");
    }
}

class C2_Class // it can also implement I_Interface, J_Interface
{
    int x = 5;

    public void display() {
        System.out.println("display method of C2_Class invoked with x = " + x);
    }

    public void print() {
        System.out.println("print method of C2_Class invoked.");
    }

    public void run() {
        System.out.println("run method of C2_Class invoked.");
    }
}

class ThirdRuleClass extends C2_Class implements I_Interface, J_Interface {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// Note in this class the third rule concept is happen because the extended class have more power than ///////////
    //// the interfaces so same signature method between the C2_class and I_Interface and J_Interface will consider the
    //// class (C2_Class) implementation rather than the interfaces, because that you have 2 option: ///////////////////
    //// either you can override the same signature method with your implementation here in this class /////////////////
    //// or don't override them and the supper class implementation will be taken in consideration. ////////////////////
    //// Note this applicable on methods that is (default or public abstract non-static) methods that have same ////////
    //// signature between the supper class and implemented interfaces. ////////////////////////////////////////////////

    @Override
    public void display() {
        System.out.println("display method of ThirdRuleClass invoked with x = " + super.x);
    }
}

public class ImplMultipleInterfaces {
    private static void printSeparator() {
        System.out.println();
        System.out.println("**********");
        System.out.println();
    }

    public static void main(String[] args) {

        printSeparator();

        C1_Class c1Class = new C1_Class();
        c1Class.display();
        c1Class.run();
        c1Class.print();

        printSeparator();

        ThirdRuleClass thirdRuleClass = new ThirdRuleClass();
        thirdRuleClass.display();
        thirdRuleClass.run();
        thirdRuleClass.print();

        printSeparator();

        I_Interface.show();
        J_Interface.show();
        C1_Class.show();

        printSeparator();

        System.out.printf("I_Interface ===> i = %d, x = %d", I_Interface.i, I_Interface.x);
        System.out.println();
        System.out.printf("J_Interface ===> x = %d", J_Interface.x);
        System.out.println();

        printSeparator();

        // I_Interface.x = 8; // Compile time error because interface variable are final.
    }
}
