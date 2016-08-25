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
    
    public boolean isGameOver = false;
    private int gameOverTick = 200;
    private static int playerDeadTime = 0;
    private int dsEasterTime = 3;
    private boolean isDsTrigger = false;
    
    
    
    public GameTracker()
    {
        GreenfootImage img = getImage();
        //img.clear();
    }
    
    public void act() 
    {
        if(isSetup == false)
        {
            setup();
            isSetup = true;
        }
        
        if(isGameOver == true)
        {
            gameOverState();
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
            if(isGameOver == false) gameOver();
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
        if(baseHealth <= 0)
        {
            if(isGameOver == false)
            {
                world.basedestroyedpic.activate();
                gameOver();
            }
        }
    }
    
    public void addScore(int value)
    {
        score = score + value;
        
        MyWorld world = (MyWorld) getWorld();
        ScoreText text = world.getScoreText();
        text.updateValue(score);
    }
    
    private void gameOver()
    {
        thisScore = score;
        if(thisScore > highScore)
        {
            highScore = thisScore;
            newHighScore = true;
        }
        else
        {
            newHighScore = false;
        }
        
        
        if(playerHealth == 0)
        {
            overReason = 0;
            playerDeadTime = (playerDeadTime + 1) % dsEasterTime;
            if(playerDeadTime == 0)
            {
                isDsTrigger = true;
                gameOverTick = 800;
            }
        }
        else
        {
            overReason = 1;
        }
        
        MyWorld myWorld = (MyWorld) getWorld();
        myWorld.song.stop();
        
        isGameOver = true;
    }
    
    private void gameOverState()
    {
        gameOverTick = gameOverTick -1;
        if(gameOverTick <= 0)
        {
            
            GameOver world = new GameOver();
            Greenfoot.setWorld(world);
        }
        
        if(isDsTrigger == true)
        {
            dsEasterEvent();
        }
    }
    
    private void dsEasterEvent()
    {
        if(gameOverTick < 700)
        {
            MyWorld world = (MyWorld) getWorld();
            world.dseasterpic.setTrans(800 - gameOverTick);
        }
        if(gameOverTick == 690)
        {
            MyWorld world = (MyWorld) getWorld();
            world.dseasterpic.playSound();
        }
    }
}
