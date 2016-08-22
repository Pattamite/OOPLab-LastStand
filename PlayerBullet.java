import greenfoot.*; 
public class PlayerBullet extends Actor
{
    public static int bulletSpeed = 12;
    public static int bulletSizeX = 12;
    public static int bulletSizeY = 12;
    
    public boolean isSetup = false;
    
    public void act() 
    {
        if(!isSetup)
        {
            setup();
            isSetup = true;
        }
        movement();
    }
    
    public void setup()
    {
        turn(-90);
    }
    
    public void movement()
    {
        if(isAtEdge())
        {
            World world = getWorld();
            world.removeObject(this);
        }
        
        else
        {
            move(bulletSpeed);
        }
    }
}
