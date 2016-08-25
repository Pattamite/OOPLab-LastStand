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

        ThisScoreText thisscoretext = new ThisScoreText();
        addObject(thisscoretext,450,390);

        HighScoreText highscoretext = new HighScoreText();
        addObject(highscoretext,450,440);

        NewHighScoreText newhighscoretext = new NewHighScoreText();
        addObject(newhighscoretext,450,490);

        PlayAgainText playagaintext = new PlayAgainText();
        addObject(playagaintext,450,630);

        ReturnToMenuText returntomenutext = new ReturnToMenuText();
        addObject(returntomenutext,450,690);

    }
}
