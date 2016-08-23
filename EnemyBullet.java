import greenfoot.*;
public class EnemyBullet extends Actor
{
    private static int bulletSpeed = 7;
    private static int bulletSizeX = 12;
    private static int bulletSizeY = 12;
    
    private boolean isSetup = false;
    
    public void act() 
    {
        if(!isSetup)
        {
            setup();
            isSetup = true;
        }
        movement();
    }
    
    private void setup()
    {
        turn(90);
    }
    
    private void movement()
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
