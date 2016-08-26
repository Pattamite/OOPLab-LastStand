import greenfoot.*;
import java.awt.Color;

public class PlayButton extends MenuClass
{
    private int fontSize = 70;
    private Color fontColor = new Color(51, 204, 51);
    private Color mouseColor = new Color(133, 224, 133);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "Play";
    private MyWorld world = new MyWorld();
  
    public PlayButton()
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
           Menu menu = (Menu) getWorld();
           menu.song.stop();
           Greenfoot.setWorld(world);
       }
    }    
}
