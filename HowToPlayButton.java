import greenfoot.*;
import java.awt.Color;

public class HowToPlayButton extends MenuClass
{
    private int fontSize = 70;
    private Color fontColor = new Color(255, 71, 26);
    private Color mouseColor = new Color(255, 133, 102);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "How to Play";
  
    public HowToPlayButton()
    {
       GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
       setImage(text);
    }
    
    public void act() 
    { 
       if(Greenfoot.mouseMoved(this) == true)
       {
           GreenfootImage text = new GreenfootImage(textString, fontSize, mouseColor, bgColor);
           setImage(text);
       }
       if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
       {
           GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
           setImage(text);
       }
       
       if (Greenfoot.mouseClicked(this)) 
       {
           HowToPlay world = new HowToPlay();
           Menu menu = (Menu) getWorld();
           menu.song.stop();
           Greenfoot.setWorld(world);
       }
    }    
}
