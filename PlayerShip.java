import greenfoot.*;
public class PlayerShip extends Actor
{
    public static int shipSpeed = 7;
    public static int shootEveryTick = 10;
    public static int currentTick = 0;
    public static int shipSizeX = 64;
    public static int shipSizeY = 49;
    public int health = 5;
    
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
        World world = getWorld();
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            currentX -= shipSpeed;
            if(currentX < (shipSizeX/2)) 
            {
                currentX = (shipSizeX/2);
            }
            setLocation(currentX, currentY);
        }
        else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            currentX += shipSpeed;
            if(currentX > (world.getWidth() - (shipSizeX/2))) 
            {
                currentX = world.getWidth() - (shipSizeX/2);
            }
            setLocation(currentX, currentY);
        }
    }
    
    public void shoot()
    {
        currentTick = (currentTick + 1) % shootEveryTick;
        if(currentTick == 0 && Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
    }
    
    public void fire()
    {
        PlayerBullet bullet = new PlayerBullet();
        World world = getWorld();
        int xPosi = getX();
        int yPosi = (int)(getY()-(shipSizeY/2));
        if(bullet != null && world != null)
        {
            world.addObject(bullet, xPosi, yPosi);
        }
    }
    
    public void hitDetection()
    {
        EnemyBullet enemyBullet = (EnemyBullet) getOneIntersectingObject(EnemyBullet.class);
        if(enemyBullet != null)
        {
            World world = getWorld();
            world.removeObject(enemyBullet);
            hit(1);
        }
        
        EnemyShip enemyShip = (EnemyShip) getOneIntersectingObject(EnemyShip.class);
        if(enemyShip != null)
        {
            World world = getWorld();
            world.removeObject(enemyShip);
            hit(2);
        }
    }
    
    public void hit(int value)
    {
        health = health - value;
        //deleteHeart
        //invincible
        if(health <= 0)
        {   
            World world = getWorld();
            world.removeObject(this);
            //gameOver
        }
    }
}
