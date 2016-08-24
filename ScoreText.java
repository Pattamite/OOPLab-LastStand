import greenfoot.*;
import java.awt.Color;

public class ScoreText extends Actor
{
    private int fontSize = 30;
    private Color fontColor = Color.WHITE;
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textCounter = "Score : ";
    
    public ScoreText()
    {
        GreenfootImage text = new GreenfootImage(textCounter + "0", fontSize, fontColor, bgColor);
        setImage(text);
    }
    
    public void updateValue(int value)
    {
        GreenfootImage text = new GreenfootImage(textCounter + value, fontSize, fontColor, bgColor);
        setImage(text);
    }
}
