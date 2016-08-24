import greenfoot.*;
import java.awt.Color;

public class PlayerHealthText extends Actor
{
    private int fontSize = 20;
    private Color fontColor = Color.WHITE;
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textCounter = "x ";
    
    public PlayerHealthText()
    {
        GreenfootImage text = new GreenfootImage(textCounter + "N/A", fontSize, fontColor, bgColor);
        setImage(text);
    }
    
    public void updateValue(int value)
    {
        GreenfootImage text = new GreenfootImage(textCounter + value, fontSize, fontColor, bgColor);
        setImage(text);
    }
}
