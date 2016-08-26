import greenfoot.*;
import java.awt.Color;


public class NewHighScoreText extends GameOverClass
{
    private int fontSize = 40;
    private Color fontColor = new Color(170, 170, 0);
    private Color blinkColor = new Color(255, 255, 0);
    private Color bgColor = new Color(0, 0, 0, 0);
    private String textString = "!!! New High Score !!!";
    private int blinkTick = 3;
    private int tickPassed = 0;
    private boolean colorBlink = false;
    
    public NewHighScoreText()
    {
        if(GameTracker.newHighScore == true)
        {
            GreenfootImage text = new GreenfootImage(textString, fontSize, fontColor, bgColor);
            setImage(text);
        }
        else
        {
            GreenfootImage text = new GreenfootImage(textString, fontSize, new Color(0, 0, 0, 0), bgColor);
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
