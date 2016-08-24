import greenfoot.*;

public class GameTracker extends Actor
{
    public static int playerHealth = 5;
    public static int baseHealth = 5;
    public static int score = 0;
    
    private boolean isSetup = false;
    
    private GreenfootImage playerPic = new GreenfootImage("PlayerHeart.png");
    private GreenfootImage pbasePic = new GreenfootImage("BaseShield.png");
    
    public void act() 
    {
        if(isSetup == false)
        {
            setup();
            isSetup = true;
        }
    }
    
    private void setup()
    {
        
    }
}
