import greenfoot.*;

public class EnemySpawner extends Actor
{
    public int level = 0;
    private int levelUpTick = 600;
    
    private int currentSpawnTick = 600;
    private int tickPerLevel = 10;
    private int tickCap = 200;
    
    private int guaranteeSpawnTick = 200;
    private int guaranteeTickPerLevel = 4;
    private int guaranteeTickCap = 80;
    
    private int tickPassed = 0;
    private int levelTickPassed = 0;
    
    private int spawnPositionX[] = {100, 200, 300, 400, 500, 600, 700, 800};
    private int spawnPositionY = 90;
    private int lastSpawnColumn = Greenfoot.getRandomNumber(spawnPositionX.length);
    
    public EnemySpawner()
    {
        GreenfootImage img = getImage();
        //img.clear();
    }
    
    public void act() 
    {
        checkTick();
        checkSpawn();
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
        int guaranteeTemp = guaranteeSpawnTick - guaranteeTickPerLevel;
        if(tempTick < tickCap)
        {
            tempTick = tickCap;
        }
        if(guaranteeTemp < guaranteeTickCap)
        {
            guaranteeTemp = guaranteeTickCap;
        }
        
        currentSpawnTick = tempTick;
        guaranteeSpawnTick = guaranteeTemp;
        levelTickPassed = 0;
    }
    
    private void checkSpawn()
    {
        if(Greenfoot.getRandomNumber(currentSpawnTick) == 0)
        {
            spawnEnemy();
        }
        
        if(tickPassed >= guaranteeSpawnTick)
        {
            spawnEnemy();
            tickPassed = 0;
        }
    }
    
    private void spawnEnemy()
    {
        int spawnColumn = Greenfoot.getRandomNumber(spawnPositionX.length - 1);
        if(spawnColumn >= lastSpawnColumn)
        {
            spawnColumn = spawnColumn + 1;
        }
        
        lastSpawnColumn = spawnColumn;
        
        World world = getWorld();
        EnemyShip enemyShip = new EnemyShip();
        world.addObject(enemyShip, spawnPositionX[spawnColumn], spawnPositionY);
    }
}
