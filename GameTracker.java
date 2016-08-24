import greenfoot.*;

public class GameTracker extends Actor
{
    public int playerHealth = 5;
    public int baseHealth = 5;
    public int score = 0;
    
    private boolean isSetup = false;
    
    private GreenfootImage playerPic = new GreenfootImage("PlayerHeart.png");
    private GreenfootImage pbasePic = new GreenfootImage("BaseShield.png");
    
    public void act() 
    {
        if(isSetup == false)
        {
            setup();
            isSetup = true;
        }
    }
    
    private void setup()
    {
        MyWorld world = (MyWorld) getWorld();
        PlayerShip player = world.getPlayerShip(); 
        playerHealth = player.health;
        
        PlayerHealthText playHealthText = world.getPlayerHealthText();
        playHealthText.updateValue(playerHealth);
        
        BaseHealthText baseHealthText = world.getBaseHealthText();
        baseHealthText.updateValue(baseHealth);
    }
    
    public void playerHit()
    {
        MyWorld world = (MyWorld) getWorld();
        PlayerShip player = world.getPlayerShip(); 
        playerHealth = player.health;
        PlayerHealthText text = world.getPlayerHealthText();
        text.updateValue(playerHealth);
        
        //if(playerHealth <= 0) gameover();
    }
    
    public void baseHit(int value)
    {
        baseHealth = baseHealth - value;
        if(baseHealth < 0) 
        {
            baseHealth = 0;
        }
        
        MyWorld world = (MyWorld) getWorld();
        BaseHealthText text = world.getBaseHealthText();
        text.updateValue(baseHealth);

        //if(playerHealth == 0) gameover();
    }
    
    public void addScore(int value)
    {
        score = score + value;
        
        MyWorld world = (MyWorld) getWorld();
        ScoreText text = world.getScoreText();
        text.updateValue(score);
    }
}
