import greenfoot.*;
import java.awt.Color;

public class OverReasonText extends GameOverClass
{
    private int fontSize = 40;
    private Color fontColor = new Color(255, 71, 26);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "OverReasonText";
    
    public OverReasonText() 
    {
        if(GameTracker.overReason == 0)
        {
            textString = "Your ship has been destroyed.";
        }
        else if(GameTracker.overReason == 1)
        {
            textString = "Your base has been destroyed.";
        }
        
        GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
        setImage(text);
    }    
}
