import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 900x800 cells with a cell size of 1x1 pixels.
        super(900, 800, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PlayerShip playership = new PlayerShip();
        addObject(playership,450,730);
        EnemySpawner enemyspawner = new EnemySpawner();
        addObject(enemyspawner,456,18);
        
        PlayerHeart playerheart = new PlayerHeart();
        addObject(playerheart,31,22);
        
        BaseShield baseshield = new BaseShield();
        addObject(baseshield,150,22);
        
        PlayerHealthText playerhealthtext = new PlayerHealthText();
        addObject(playerhealthtext,70,22);
        
        BaseHealthText basehealthtext = new BaseHealthText();
        addObject(basehealthtext,190,22);

    }
}
