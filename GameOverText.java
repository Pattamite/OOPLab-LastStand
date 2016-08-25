import greenfoot.*;
import java.awt.Color;

public class GameOverText extends GameOverClass
{
    private int fontSize = 90;
    private Color fontColor = new Color(255, 26, 26);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "Game Over";
    
    public GameOverText() 
    {
        GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
        setImage(text);
    }     
}
