import greenfoot.*;

public class EnemySpawner extends Actor
{
    public int level = 0;
    private int levelUpTick = 600;
    
    private int currentSpawnTick = 600;
    private int tickPerLevel = 20;
    private int tickCap = 200;
    
    private int guaranteeSpawnTick = 200;
    private int guaranteeTickPerLevel = 8;
    private int guaranteeTickCap = 80;
    
    private int tickPassed = 0;
    private int levelTickPassed = 0;
    
    private int spawnPositionX[] = {100, 200, 300, 400, 500, 600, 700, 800};
    private int spawnPositionY = 80;
    private int lastSpawnColumn = Greenfoot.getRandomNumber(spawnPositionX.length);
    
    private int enemyTypeRate[] = {100, 0, 0};
    
    public EnemySpawner()
    {
        GreenfootImage img = getImage();
        img.clear();
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
        if(level == 3)
        {
            enemyTypeRate[0] = 80;
            enemyTypeRate[1] = 0;
            enemyTypeRate[2] = 20;
        }
        else if(level == 4)
        {
            enemyTypeRate[0] = 60;
            enemyTypeRate[1] = 0;
            enemyTypeRate[2] = 40;
        }
        else if(level == 5)
        {
            enemyTypeRate[0] = 55;
            enemyTypeRate[1] = 10;
            enemyTypeRate[2] = 35;
        }
        else if(level == 6)
        {
            enemyTypeRate[0] = 50;
            enemyTypeRate[1] = 20;
            enemyTypeRate[2] = 30;
        }
        else if(level == 8)
        {
            enemyTypeRate[0] = 40;
            enemyTypeRate[1] = 30;
            enemyTypeRate[2] = 30;
        }
        else if(level == 11)
        {
            enemyTypeRate[0] = 20;
            enemyTypeRate[1] = 40;
            enemyTypeRate[2] = 40;
        }
        else if(level == 15)
        {
            enemyTypeRate[0] = 10;
            enemyTypeRate[1] = 45;
            enemyTypeRate[2] = 45;
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
        World world = getWorld();
        
        int spawnColumn = Greenfoot.getRandomNumber(spawnPositionX.length - 1);
        if(spawnColumn >= lastSpawnColumn)
        {
            spawnColumn = spawnColumn + 1;
        }
        lastSpawnColumn = spawnColumn;
        
        int enemyType = Greenfoot.getRandomNumber(100);
        if(enemyType < enemyTypeRate[0])
        {
            EnemyShip enemyShip = new EnemyShip();
            world.addObject(enemyShip, spawnPositionX[spawnColumn], spawnPositionY);
        }
        else if(enemyType < (enemyTypeRate[0] + enemyTypeRate[1]))
        {
            EnemyShip2 enemyShip = new EnemyShip2();
            world.addObject(enemyShip, spawnPositionX[spawnColumn], spawnPositionY);
        }
        else
        {
            EnemyShip3 enemyShip = new EnemyShip3();
            world.addObject(enemyShip, spawnPositionX[spawnColumn], spawnPositionY);
        }
        
    }
}
