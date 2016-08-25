import greenfoot.*;

public class GameOver extends World
{
    public GameOver()
    {    
        super(900, 800, 1); 
        prepare();
    }
    
    private void prepare()
    {
        setBackground(new GreenfootImage("GameBackground.png"));

        GameOverText gameovertext = new GameOverText();
        addObject(gameovertext,450,160);

        OverReasonText overreasontext = new OverReasonText();
        addObject(overreasontext,450,250);

    }
}
