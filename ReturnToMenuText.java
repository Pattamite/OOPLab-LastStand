import greenfoot.*;
import java.awt.Color;

public class ReturnToMenuText extends GameOverClass
{
    private int fontSize = 50;
    private Color fontColor = new Color(255, 255, 0);
    private Color mouseColor = new Color(255, 255, 153);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "Return to Main Menu";
    private Menu world = new Menu();
    
    public ReturnToMenuText()
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
           GameOver gameOver = (GameOver) getWorld();
           gameOver.song.stop();
           Greenfoot.setWorld(world);
       }
    }    
}
