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
        enemyship6.setLocation(102,90);
        enemyship.setLocation(194,89);
        enemyship2.setLocation(318,89);
        enemyship.setLocation(208,88);
        enemyship3.setLocation(421,87);
        enemyship4.setLocation(529,88);
        enemyship5.setLocation(635,88);
        EnemyShip enemyship7 = new EnemyShip();
        addObject(enemyship7,740,93);
        enemyship.setLocation(203,92);
        enemyship2.setLocation(302,90);
        enemyship3.setLocation(406,88);
        enemyship4.setLocation(505,89);
        enemyship5.setLocation(603,91);
        enemyship7.setLocation(704,92);
        EnemyShip enemyship8 = new EnemyShip();
        addObject(enemyship8,806,96);
        removeObject(enemyship6);
        removeObject(enemyship);
        removeObject(enemyship2);
        removeObject(enemyship3);
        removeObject(enemyship4);
        removeObject(enemyship5);
        removeObject(enemyship7);
        removeObject(enemyship8);
        EnemySpawner enemyspawner = new EnemySpawner();
        addObject(enemyspawner,456,18);
    }
}
