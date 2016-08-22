import greenfoot.*;
public class PlayerShip extends Actor
{
    public static int shipSpeed = 7;
    public static int shootEveryTick = 10;
    public static int currentTick = 0;
    public static int shipSizeX = 64;
    public static int shipSizeY = 49;
    public int invincTick = 100;
    public int health = 5;
    public int remainInvincTick = 0;
    public int invincBlinkTick = 4;
    
    private GreenfootImage trans = new GreenfootImage("playerShip1_blue_invi.png");
    private GreenfootImage normal = new GreenfootImage("playerShip1_blue.png");
    
    public void act() 
    {
        movement();
        shoot();
        hitDetection();
        if(remainInvincTick > 0)
        {
            invincible();
        }
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
        if(Greenfoot.isKeyDown("space")) 
        {
            if(currentTick == 0)
            {
                fire();
            }
            currentTick = (currentTick + 1) % shootEveryTick;
        }
        else
        {
            currentTick = 0;
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
        if(remainInvincTick <= 0)
        {
            health = health - value;
            //deleteHeart
            remainInvincTick = invincTick;
        }
        
        if(health <= 0)
        {   
            World world = getWorld();
            world.removeObject(this);
            //gameOver
        }
    }
    
    public void invincible()
    {
        if(remainInvincTick == 1) 
        {
            setImage(normal);
        }
        else if(remainInvincTick % invincBlinkTick == 0)
        {
            if(getImage() == normal)
            {
                setImage(trans);
            }
            else
            {
                setImage(normal);
            }
        }
        
        remainInvincTick = remainInvincTick -1;
    }
}
