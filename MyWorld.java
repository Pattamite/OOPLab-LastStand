import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
        EnemyShip enemyship = new EnemyShip();
        addObject(enemyship,239,86);
        EnemyShip enemyship2 = new EnemyShip();
        addObject(enemyship2,394,88);
        EnemyShip enemyship3 = new EnemyShip();
        addObject(enemyship3,509,89);
        EnemyShip enemyship4 = new EnemyShip();
        addObject(enemyship4,632,89);
        EnemyShip enemyship5 = new EnemyShip();
        addObject(enemyship5,764,92);
        EnemyShip enemyship6 = new EnemyShip();
        addObject(enemyship6,86,79);
    }
}
