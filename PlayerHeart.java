import greenfoot.*;

public class PlayerHeart extends Actor
{   
    public boolean isActive = false;
    
    private int totalBlinkTick = 90;
    private int blinkTick = 3;
    private int remainTick = 0;
    
    private GreenfootImage normal = new GreenfootImage("PlayerHeart.png");
    private GreenfootImage trans = new GreenfootImage("PlayerHeartTrans.png");
    
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
