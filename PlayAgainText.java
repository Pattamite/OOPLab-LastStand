import greenfoot.*;
import java.awt.Color;

public class PlayAgainText extends GameOverClass
{
    private int fontSize = 50;
    private Color fontColor = new Color(51, 204, 51);
    private Color mouseColor = new Color(133, 224, 133);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "Play Again";
    private MyWorld world = new MyWorld();
    
    public PlayAgainText()
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
           Greenfoot.setWorld(world);
       }
    }    
}
