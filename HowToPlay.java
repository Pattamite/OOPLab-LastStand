import greenfoot.*; 
public class HowToPlay extends World
{


    public HowToPlay()
    {    
        super(900, 800, 1);
        prepare();
    }
    
    private void prepare()
    {
        setBackground(new GreenfootImage("GameBackground.png"));

        HowToPlayPic howtoplaypic = new HowToPlayPic();
        addObject(howtoplaypic,450,340);
        ReturnText returntext = new ReturnText();
        addObject(returntext,450,680);
    }
}
