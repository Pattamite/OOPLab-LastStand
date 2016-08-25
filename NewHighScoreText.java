import greenfoot.*;
import java.awt.Color;


public class NewHighScoreText extends GameOverClass
{
    private int fontSize = 40;
    private Color fontColor = new Color(128, 128, 0);
    private Color blinkColor = new Color(255, 255, 153);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "!!! New High Score !!!";
    private int blinkTick = 2;
    private int tickPassed = 0;
    private boolean colorBlink = false;
    
    public NewHighScoreText()
    {
        if(GameTracker.newHighScore == true)
        {
            GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
            setImage(text);
        }
    }
    
    public void act() 
    {
        if(GameTracker.newHighScore == true)
        {
            blink();
        }
    }
    
    public void blink()
    {
        tickPassed = (tickPassed + 1) % blinkTick;
        if(tickPassed == 0)
        {
            if(colorBlink == true)
            {
                GreenfootImage text = new GreenfootImage(textString, fontSize, blinkColor, bgColor);
                setImage(text);
                
                colorBlink = false;
            }
            else
            {
                GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
                setImage(text);
                
                colorBlink = true;
            }
        }
    }
}
