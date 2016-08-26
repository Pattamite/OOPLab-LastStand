import greenfoot.*;

public class MyWorld extends World
{
    public PlayerShip playership;
    public EnemySpawner enemyspawner;
    public PlayerHeart playerheart;
    public BaseShield baseshield;
    public PlayerHealthText playerhealthtext;
    public BaseHealthText basehealthtext;
    public GameTracker gametracker;
    public ScoreText scoretext;
    public DsEasterPic dseasterpic;
    public BaseDestroyedPic basedestroyedpic;
    
    public GreenfootSound song = new GreenfootSound("GameSong.mp3");
    private boolean isSetup = false;
    private int songVolume = 43;
    
    public MyWorld()
    {    
        // Create a new world with 900x800 cells with a cell size of 1x1 pixels.
        super(900, 800, 1); 
        prepare();
    }

    private void prepare()
    {
        setPaintOrder(DsEasterPic.class);
        setBackground(new GreenfootImage("GameBackground.png"));

        playership = new PlayerShip();
        addObject(playership,450,730);

        enemyspawner = new EnemySpawner();
        addObject(enemyspawner,456,18);

        playerheart = new PlayerHeart();
        addObject(playerheart,31,22);

        baseshield = new BaseShield();
        addObject(baseshield,150,22);

        playerhealthtext = new PlayerHealthText();
        addObject(playerhealthtext,70,22);

        basehealthtext = new BaseHealthText();
        addObject(basehealthtext,190,22);

        gametracker = new GameTracker();
        addObject(gametracker,0,0);

        scoretext = new ScoreText();
        addObject(scoretext,770,22);

        dseasterpic = new DsEasterPic();
        addObject(dseasterpic,450,400);

        basedestroyedpic = new BaseDestroyedPic();
        addObject(basedestroyedpic,450,700);
    }
    
    public void act()
    {
        if(isSetup == false)
        {
            setup();
        }
    }
    
    private void setup()
    {
        song.setVolume(songVolume);
        song.playLoop();
        isSetup = true;
    }
    
    public PlayerShip getPlayerShip()
    {
        return playership;
    }
    
    public EnemySpawner getEnemySpawner()
    {
        return enemyspawner;
    }
    
    public PlayerHeart getPlayerHeart()
    {
        return playerheart;
    }
    
    public BaseShield getBaseShield()
    {
        return baseshield;
    }
    
    public PlayerHealthText getPlayerHealthText()
    {
        return playerhealthtext;
    }
    
    public BaseHealthText getBaseHealthText()
    {
        return basehealthtext;
    }
    
    public GameTracker getGameTracker()
    {
        return gametracker;
    }
    
    public ScoreText getScoreText()
    {
        return scoretext;
    }
    
    public DsEasterPic getDsEasterPic()
    {
        return dseasterpic;
    }
    
    public BaseDestroyedPic getBaseDestroyedPic()
    {
        return basedestroyedpic;
    }
}
