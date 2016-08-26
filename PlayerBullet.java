import greenfoot.*; 
public class PlayerBullet extends Actor
{
    private static int bulletSpeed = 12;
    private static int bulletSizeX = 12;
    private static int bulletSizeY = 12;
    
    private boolean isSetup = false;
    private GreenfootSound fireSound = new GreenfootSound("PlayerFire.mp3");
    
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
        turn(-90);
        fireSound.play();
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
