import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnemySpawner extends Actor
{
    public int level = 0;
    private int levelUpTick = 600;
    private int currentSpawnTick = 200;
    private int tickPerLevel = 7;
    private int tickCap = 30;
    private int tickPassed = 0;
    private int levelTickPassed = 0;
    private int spawnPositionX[] = {100, 200, 300, 400, 500, 600, 700, 800};
    private int spawnPositionY = 90;
    
    
    
    public void act() 
    {
        checkTick();
        spawnEnemy();
    }
    
    private void checkTick()
    {
        tickPassed = tickPassed +1;
        levelTickPassed = levelTickPassed + 1;
        if(levelTickPassed >= levelUpTick)
        {
            levelUp();
        }
    }
    
    private void levelUp()
    {
        level = level + 1;
        
        int tempTick = currentSpawnTick - tickPerLevel;
        if(tempTick < tickCap)
        {
            tempTick = tickCap;
        }
        
        currentSpawnTick = tempTick;
        levelTickPassed = 0;
    }
    
    private void spawnEnemy()
    {
        if(Greenfoot.getRandomNumber(currentSpawnTick) == 0)
        {
            World world = getWorld();
            EnemyShip enemyShip = new EnemyShip();
            
            world.addObject(enemyShip, spawnPositionX[ Greenfoot.getRandomNumber(spawnPositionX.length) ], spawnPositionY);
        }
    }
}
