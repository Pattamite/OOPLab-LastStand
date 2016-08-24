import greenfoot.*;

public class BaseShield extends Actor
{
    public boolean isActive = false;
    
    private int totalBlinkTick = 90;
    private int blinkTick = 3;
    private int remainTick = 0;
    
    private GreenfootImage normal = new GreenfootImage("BaseShield.png");
    private GreenfootImage trans = new GreenfootImage("BaseShieldTrans.png");
    
    public void act() 
    {
        if(isActive == true) blink();
    }
    
    private void blink()
    {
        if(remainTick <=0)
        {
            setImage(normal);
            isActive = false;
        }
        else if(remainTick % blinkTick == 0)
        {
            if(getImage() == normal)
            {
                setImage(trans);
            }
            else
            {
                setImage(normal);
            }
        }
        
        remainTick = remainTick - 1;
    }
    
    public void blinkActive()
    {
        remainTick = totalBlinkTick;
        isActive = true;
    }
}
