import greenfoot.*; 

public class EnemyShip3 extends Actor
{
    public static int shipSpeed = 1;
    public static int shootEveryTick = 120;
    public static int score = 100;
    private static int shipSizeX = 61;
    private static int shipSizeY = 70;
    
    public int health = 3;
    public boolean isDead = false;
    private GreenfootImage health2 = new GreenfootImage("enemyBlack5_damage1.png");
    private GreenfootImage health1 = new GreenfootImage("enemyBlack5_damage2.png");
    
    public void act() 
    {
        movement();
        shoot();
        hitDetection();
        checkAtBase();
        checkDead();
    }
    
    private void movement()
    {
        int currentX = getX();
        int currentY = getY();
        
        setLocation(currentX, currentY + shipSpeed);
    }
    
    private void shoot()
    {
 
        if(Greenfoot.getRandomNumber(shootEveryTick) == 0) 
        {
            fire();
        }
    }
    
    private void fire()
    {
        MyWorld myWorld = (MyWorld) getWorld();
        EnemyBullet bullet = new EnemyBullet();
        if(myWorld.gametracker.isGameOver == false && getY() < 700)
        {
            bullet.isHoming = true;
        }
        else
        {
            bullet.degree = 90;
        }
        
        World world = getWorld();
        int xPosi = getX();
        int yPosi = (int)(getY()+(shipSizeY/2));
        if(bullet != null && world != null)
        {
            world.addObject(bullet, xPosi, yPosi);
        }
    }
    
    private void hitDetection()
    {
        PlayerBullet playerBullet = (PlayerBullet) getOneIntersectingObject(PlayerBullet.class);
        if(playerBullet != null)
        {
            World world = getWorld();
            world.removeObject(playerBullet);
            hit(1);
        }
    }
    
    private void hit(int value)
    {
        health = health - value;
        if(health == 2) 
        {
            setImage(health2);
        }
        else if(health == 1)
        {
            setImage(health1);
        }
        else if(health <= 0)
        {
            addScore(score);
            isDead = true;
        }
    }
    
    private void checkDead()
    {
        if(isDead == true)
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
    
    private void addScore(int value)
    {
        MyWorld world = (MyWorld) getWorld();
        GameTracker tracker = world.getGameTracker();
        tracker.addScore(score);
    }
    
    private void checkAtBase()
    {
        if(isAtEdge() == true)
        {
            MyWorld world = (MyWorld) getWorld();
            GameTracker tracker = world.getGameTracker();
            tracker.baseHit(1);
            isDead = true;
        }
    } 
}
