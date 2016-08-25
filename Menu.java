import greenfoot.*;


public class Menu extends World
{

    public Menu()
    {    
        super(900, 800, 1);
        prepare();
    }

    private void prepare()
    {
        setBackground(new GreenfootImage("GameBackground.png"));

        TitleText titletext = new TitleText();
        addObject(titletext,450,200);

        PlayButton playbutton = new PlayButton();
        addObject(playbutton,450,430);

        HowToPlayButton howtoplaybutton = new HowToPlayButton();
        addObject(howtoplaybutton,450,525);
    }
}
