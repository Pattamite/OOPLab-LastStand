import greenfoot.*;

public class EnemyShip2 extends Actor
{
    public static int shipSpeed = 1;
    public static int shootEveryTick = 200;
    public static int score = 200;
    private static int shipSizeX = 75;
    private static int shipSizeY = 77;
    private static int degreeChange = 20;
    
    public int health = 5;
    public boolean isDead = false;
    private GreenfootImage health2 = new GreenfootImage("enemyShip_2_damaged1.png");
    private GreenfootImage health1 = new GreenfootImage("enemyShip_2_damaged2.png");
    
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
        EnemyBullet bullet = new EnemyBullet();
        bullet.degree = 90;
        EnemyBullet bullet2 = new EnemyBullet();
        bullet2.degree = 90 + degreeChange;
        EnemyBullet bullet3 = new EnemyBullet();
        bullet3.degree = 90 - degreeChange;
        World world = getWorld();
        int xPosi = getX();
        int yPosi = (int)(getY()+(shipSizeY/2));
        if( world != null)
        {
            world.addObject(bullet, xPosi, yPosi);
            world.addObject(bullet2, xPosi, yPosi-1);
            world.addObject(bullet3, xPosi, yPosi+1);
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
        if(health == 3) 
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
