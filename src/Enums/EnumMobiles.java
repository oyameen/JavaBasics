package Enums;

import java.util.EnumSet;


enum Mobiles {   // by default extends Enum Class
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // By default, enum value are public static final but in modern java it is not allowed to provide it ///////////
    // and other modifier not allowed for enum constants because it is by default public static final //////////////
    // the message when you provide any modifier is ==> "No modifiers allowed for enum constants." /////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    IPHONE(1000, 900),

    SAMSUNG(700, 650),

    HTC {
        //////////////////////////////////////////////////////////////////////////
        ///// The following override called "Constant Specific Class Body." //////
        ///// it use anonymous inner classes by this approach, ///////////////////
        //////////////////////////////////////////////////////////////////////////
        @Override
        public int getOriginalPrice() {
            return 5;
        }

        @Override
        public int getPriceAfterDiscount() {
            return 4;
        }
    },

    MOTOROLA;

    /////////////////////////////////////////////////////////////////
    ///// variable can have any access modifier like any class //////
    /////////////////////////////////////////////////////////////////
    private final int originalPrice;
    private int priceAfterDiscount;
    protected int releaseDate;
    int cameraNumber;
    private static final String str1 = "XYZ1";
    private static String str2;

    Mobiles() {
        originalPrice = 0;
        priceAfterDiscount = 0;
        releaseDate = 2010;
        cameraNumber = 3;
    }

    Mobiles(int originalPrice, int priceAfterDiscount) {
        this.originalPrice = originalPrice;
        this.priceAfterDiscount = priceAfterDiscount;
    }
    /////////////////////////////////////////////////////////////////
    ///// methods can have any access modifier like any class ///////

    ///// can have getter/setter like any class /////////////////////
    /////////////////////////////////////////////////////////////////

    public int getOriginalPrice() {
        return originalPrice;
    }

    public int getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(int priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getCameraNumber() {
        return cameraNumber;
    }

    public void setCameraNumber(int cameraNumber) {
        this.cameraNumber = cameraNumber;
    }

    public static String getStr1() {
        return str1;
    }

    public static String getStr2() {
        return str2;
    }

    public static void setStr2(String str2) {
        Mobiles.str2 = str2;
    }

    /////////////////////////////////////////////////////
    ///// you can override toString /////////////////////
    /////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "Mobiles{" +
                "originalPrice=" + originalPrice +
                ", priceAfterDiscount=" + priceAfterDiscount +
                ", releaseDate=" + releaseDate +
                ", cameraNumber=" + cameraNumber +
                // not recommended to have static field in toString() for str1 and str2
                ", str1=" + str1+
                ", Mobiles.str2=" + Mobiles.str2+
                '}';
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///// overriding equal() and hashCode() not allowed because cannot create object from enum ///////////////////
    ///// and Enum constants in Java are implicitly final. ///////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///// you can use normal (non-static) inner class and static inner class inside the enum /////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class NestedNormalClass {
        private int i;

        public NestedNormalClass(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    static class NestedStaticClass {
        private int i;

        NestedStaticClass(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}


public class EnumMobiles {

    // enum can be defined inside the class.
    enum MobileQuality {
        BEST {
            @Override
            void print() {
                System.out.println("best");
            }
        }, AVERAGE {
            @Override
            void print() {
                System.out.println("average");
            }
        }, BAD {
            @Override
            void print() {
                System.out.println("bad");
            }
        };

        //////////////////////////////////////////////////////////
        // all enum should override it as anonymous classes //////
        //////////////////////////////////////////////////////////
        abstract void print();

        /*default -> not allowed because it is for interface*/ void show() {
            System.out.println("Inside show method");
        }

        //// you can have interface inside the enum
        interface EnumHandler {
            void enumHandle();

            default void run() {
                System.out.println("Inside run method in EnumHandler interface.");
            }
        }
    }


    public static void main(String[] args) {
        Mobiles[] m = Mobiles.values();
        for (Mobiles i : m) {
            System.out.println("Mobile = " + i + ", having originalPrice = " + i.getOriginalPrice() + ", and have priceAfterDiscount = " + i.getPriceAfterDiscount() + ", and have Str = " + Mobiles.getStr1());
        }
        for (Mobiles i : EnumSet.of(Mobiles.SAMSUNG, Mobiles.MOTOROLA)) {
            System.out.println("Mobile = " + i);
        }

        ////////////
        Mobiles.NestedNormalClass nestedNormalClass = Mobiles.IPHONE.new NestedNormalClass(5);
        System.out.println("Normal inner class i value  = " + nestedNormalClass.getI());

        Mobiles.NestedStaticClass nestedStaticClass = new Mobiles.NestedStaticClass(4);
        System.out.println("Static inner class i value  = " + nestedStaticClass.getI());
        ////////////
        MobileQuality.BEST.print();
        MobileQuality.AVERAGE.show();
        ////////////
        MobileQuality.EnumHandler enumHandler1 = new MobileQuality.EnumHandler() {
            @Override
            public void enumHandle() {
                System.out.println("Inside enumHandler method  in EnumHandler interface. 1.");
            }
        };
        enumHandler1.enumHandle();
        enumHandler1.run();
        /////////////
        MobileQuality.EnumHandler enumHandler2 = () -> System.out.println("Inside enumHandler method in EnumHandler interface. 2.");
        enumHandler2.enumHandle();
        enumHandler2.run();
    }
}