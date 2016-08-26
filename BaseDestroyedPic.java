import greenfoot.*; 

public class BaseDestroyedPic extends Actor
{
    private GreenfootImage pic = new GreenfootImage("baseDestroyed.png");
    private GreenfootSound sound = new GreenfootSound("BaseDown.mp3");
    
    private int transValue = 0;
    private int transRate = 3;
    private boolean isActive = false;
    
    public BaseDestroyedPic()
    {
           pic.setTransparency(transValue);
           setImage(pic);
    }
    
    public void act() 
    {
        if(isActive == true)
        {
            setPic();
        }
    }
    
    private void setPic()
    {
        transValue = transValue - transRate;
        if(transValue < 0)
        {
            transValue = 0;
            isActive = false;
        }
        pic.setTransparency(transValue);
        setImage(pic);
    }
    
    public void activate()
    {
        isActive = true;
        transValue = 255;
        sound.play();
    }
}
