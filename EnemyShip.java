import greenfoot.*;


public class EnemyShip extends Actor
{

    public static int shipSpeed = 1;
    public static int shootEveryTick = 80;
    public static int shipSizeX = 68;
    public static int shipSizeY = 55;
    public int health = 3;
    
    public void act() 
    {
        movement();
        shoot();
        hitDetection();
    }
    
    public void movement()
    {
        int currentX = getX();
        int currentY = getY();
        
        setLocation(currentX, currentY + shipSpeed);
    }
    
    public void shoot()
    {
 
        if(Greenfoot.getRandomNumber(shootEveryTick) == 0) 
        {
            fire();
        }
    }
    
    public void fire()
    {
        EnemyBullet bullet = new EnemyBullet();
        World world = getWorld();
        int xPosi = getX();
        int yPosi = (int)(getY()+(shipSizeY/2));
        if(bullet != null && world != null)
        {
            world.addObject(bullet, xPosi, yPosi);
        }
    }
    
    public void hitDetection()
    {
        PlayerBullet playerBullet = (PlayerBullet) getOneIntersectingObject(PlayerBullet.class);
        if(playerBullet != null)
        {
            World world = getWorld();
            world.removeObject(playerBullet);
            hit(1);
        }
    }
    
    public void hit(int value)
    {
        health = health - value;
        if(health <= 0)
        {
            //addScore
            World world = getWorld();
            world.removeObject(this);
        }
    }
}
