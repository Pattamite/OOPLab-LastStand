import greenfoot.*;
import java.awt.Color;


public class HighScoreText extends GameOverClass
{
    private int fontSize = 40;
    private Color fontColor = new Color(26, 117, 255);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "HighScoreText";
    
    public HighScoreText() 
    {
        textString = "High Score : " + GameTracker.highScore ;
        
        GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
        setImage(text);
    }    
}
