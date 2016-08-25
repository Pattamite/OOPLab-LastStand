import greenfoot.*;
public class EnemyBullet extends Actor
{
    private static int bulletSpeed = 7;
    private static int bulletSizeX = 12;
    private static int bulletSizeY = 12;
    
    private boolean isSetup = false;
    private boolean isHoming = false;
    public int degree = 90;
    
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
        if(isHoming == true)
        {
            MyWorld world = (MyWorld) getWorld();
            if(world.playership != null)
            {
                int xTarget = world.playership.getX();
                int yTarget = world.playership.getY();
                turnTowards(xTarget, yTarget);
            }
            else 
            {
                turn(degree);
            }
        }
        else 
        {
            turn(degree);
        }
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
