import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DsEasterPic extends Actor
{
    GreenfootImage pic = new GreenfootImage("YouDiedPic.png");
    GreenfootSound sound = new GreenfootSound("YouDied.mp3");
    public DsEasterPic()
    {
        pic.setTransparency(0);
        setImage(pic);
    }
    
    public void setTrans(int value)
    {
        if(value < 0) value = 0;
        else if(value > 255) value = 255;
        
        pic.setTransparency(value);
        setImage(pic);
    }
    
    public void playSound()
    {
        sound.play();
    }
}
