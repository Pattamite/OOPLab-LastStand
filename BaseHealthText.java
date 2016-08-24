import greenfoot.*;
import java.awt.Color;

public class BaseHealthText extends Actor
{
    private int fontSize = 20;
    private Color fontColor = Color.BLACK;
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textCounter = "x ";
    
    
    public BaseHealthText()
    {
        GreenfootImage text = new GreenfootImage(textCounter + "200", fontSize, fontColor, bgColor);
        setImage(text);
    }
    
    public void updateValue(int value)
    {
        GreenfootImage text = new GreenfootImage(textCounter + value, fontSize, fontColor, bgColor);
        setImage(text);
    }
}
