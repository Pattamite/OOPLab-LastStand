import greenfoot.*;

public class GameTracker extends Actor
{
    public int playerHealth = 5;
    public int baseHealth = 5;
    public int score = 0;
    
    public static int highScore = 0;
    public static int thisScore = 0;
    public static int overReason = 0;
    public static boolean newHighScore = true;
    
    private boolean isSetup = false;
    
    private GreenfootImage playerPic = new GreenfootImage("PlayerHeart.png");
    private GreenfootImage basePic = new GreenfootImage("BaseShield.png");
    
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
        
        PlayerHealthText playHealthText = world.getPlayerHealthText();
        playHealthText.updateValue(playerHealth);
        
        BaseHealthText baseHealthText = world.getBaseHealthText();
        baseHealthText.updateValue(baseHealth);
    }
    
    public void playerHit(int value)
    {
        playerHealth = playerHealth - value;
        if(playerHealth < 0)
        {
            playerHealth = 0;
        }
        
        MyWorld world = (MyWorld) getWorld();
        PlayerHealthText text = world.getPlayerHealthText();
        text.updateValue(playerHealth);
        PlayerHeart playerHeart = world.getPlayerHeart();
        playerHeart.blinkActive();
        
        if(playerHealth <= 0) 
        {
            PlayerShip player = world.getPlayerShip();
            player.isDead = true;
            //gameover();
        }
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
        BaseShield baseShield = world.getBaseShield();
        baseShield.blinkActive();

        //if(baseHealth <= 0) gameover();
    }
    
    public void addScore(int value)
    {
        score = score + value;
        
        MyWorld world = (MyWorld) getWorld();
        ScoreText text = world.getScoreText();
        text.updateValue(score);
    }
}
