package OOB;

public class InheritanceExample1
{
    public static void main(String[] args)
    {
        Add lAdd = new Add();
        lAdd.sum();//Add
        lAdd.display();
        ////
        Add lAdd1 = new AddSub();
        lAdd1.sum();//AddSub
        lAdd1.display();
        ////
        Add lAdd2 = new AddSubMul();
        lAdd2.sum();//AddSubMul
        lAdd2.display();
        ////
        Add lAdd3 = new AddMul();
        lAdd3.sum();//AddMul
        lAdd3.display();
        ////
        AddSub lAddSub = new AddSub();
        lAddSub.sum();//AddSub
        lAddSub.sub();//AddSub
        lAddSub.display();
        ////
        AddSub lAddSub1 = new AddSubMul();
        lAddSub1.sum();//AddSubMul
        lAddSub1.sub();//AddSubMul
        lAddSub1.display();
        ////
        AddSubMul lAddSubMul = new AddSubMul();
        lAddSubMul.sum();//AddSubMul
        lAddSubMul.sub();//AddSubMul
        lAddSubMul.mul();//AddSubMul
        lAddSubMul.display();


    }
}

class Add
{
   public void sum()
   {
       System.out.println("in Add sum");
   }
   public void display()
   {
       System.out.println("in Add display");
   }
}
class AddSub extends Add
{
    public void sum()
    {
        System.out.println("in AddSub sum");
    }
    public void sub()
    {
        System.out.println("in AddSub sub");
    }
}
class AddSubMul extends AddSub
{
    public void sum()
    {
        System.out.println("in AddSubMul sum");
    }
    public void sub()
    {
        System.out.println("in AddSubMul sub");
    }
    public void mul()
    {
        System.out.println("in AddSubMul mul");
    }
}
class AddMul extends Add
{
    public void sum()
    {
        System.out.println("in AddMul sum");
    }
    public void mul()
    {
        System.out.println("in AddMul mul");
    }
}

