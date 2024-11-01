package OOB;

public class AbstractionExample1
{
    public static void main(String[] args)
    {
        PhoneSetting lPhoneSetting = new PhoneSetting();
        lPhoneSetting.makeSmartPhoneCall(new Samsung());
        lPhoneSetting.makeSmartPhoneCall(new Iphone());
        lPhoneSetting.makeOldPhoneCall(new FeaturedPhone());
        ////
        lPhoneSetting.runSmartPhoneMusic(new Samsung());
        lPhoneSetting.runSmartPhoneMusic(new Iphone());
        lPhoneSetting.runOldPhoneMusic(new FeaturedPhone());
        ////
        lPhoneSetting.runSmartPhoneTakePicture(new Samsung());
        lPhoneSetting.runSmartPhoneTakePicture(new Iphone());
        //////////////
        System.out.println("***");
        Samsung lSamsung = new Samsung();
        lSamsung.call();
        lSamsung.playGame();
        lSamsung.playMusic();
        lSamsung.takePicture();
        ////
        Iphone lIphone = new Iphone();
        lIphone.call();
        lIphone.openCalculator();
        lIphone.playMusic();
        lIphone.takePicture();
        ////
        FeaturedPhone lFeaturedPhone = new FeaturedPhone();
        lFeaturedPhone.call();
        lFeaturedPhone.turnOnRadio();
        lFeaturedPhone.playMusic();
    }
}
abstract class Phone
{
    abstract public void call();

    public void playMusic()
    {
        System.out.println("Phone Play Music...");
    }
}

abstract class SmartPhone extends Phone
{
    abstract public void takePicture();
}

class Samsung extends SmartPhone
{

    @Override
    public void call()
    {
        System.out.println("Samsung call ...");
    }

    @Override
    public void takePicture()
    {
        System.out.println("Samsung take a picture ...");
    }
    public void playMusic()
    {
        System.out.println("Samsung Play Music ...");
    }
    public void playGame()
    {
        System.out.println("Samsung Play Game ...");
    }
}

class Iphone extends SmartPhone
{

    @Override
    public void call()
    {
        System.out.println("Iphone call ...");
    }

    @Override
    public void takePicture()
    {
        System.out.println("Iphone take a picture ...");
    }

    public void openCalculator()
    {
        System.out.println("Iphone open Calculator ...");
    }
}

class FeaturedPhone extends Phone
{

    @Override
    public void call()
    {
        System.out.println("FeaturedPhone call ...");
    }
    public void turnOnRadio()
    {
        System.out.println("FeaturedPhone turn On Radio ...");
    }
}

class PhoneSetting
{
    public void makeSmartPhoneCall(SmartPhone aInSmartPhone)
    {
        aInSmartPhone.call();
    }
    public void runSmartPhoneMusic(SmartPhone aInSmartPhone)
    {
        aInSmartPhone.playMusic();
    }
    public void runSmartPhoneTakePicture(SmartPhone aInSmartPhone)
    {
        aInSmartPhone.takePicture();
    }

    public void makeOldPhoneCall(Phone aInPhone)
    {
        aInPhone.call();
    }
    public void runOldPhoneMusic(Phone aInPhone)
    {
        aInPhone.playMusic();
    }
}