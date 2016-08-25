import greenfoot.*;
import java.awt.Color;
public class TitleText extends MenuClass
{
    private int fontSize = 90;
    private Color fontColor = new Color(102, 102, 255);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "The Last Stand";
    
    public TitleText() 
    {
        GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
        setImage(text);
    }    
}
