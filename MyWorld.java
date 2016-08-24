import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    
    public MyWorld()
    {    
        // Create a new world with 900x800 cells with a cell size of 1x1 pixels.
        super(900, 800, 1); 
        prepare();
    }

    private void prepare()
    {
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
}
