import greenfoot.*;
import java.awt.Color;

public class ThisScoreText extends GameOverClass
{
    private int fontSize = 40;
    private Color fontColor = new Color(0, 255, 0);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "TisScoreText";
    
    public ThisScoreText() 
    {
        textString = "Score : " + GameTracker.thisScore;
        
        GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
        setImage(text);
    }    
}
