import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WaitingWorld extends World
{
    private boolean playerHere = false;
    private GameProxy gameProxy;

    public WaitingWorld()
    {
        super(800, 600, 1);
        gameProxy = new GameProxy();
        setBackground(new GreenfootImage("WaitingWorldBG.jpg"));
    }

    public void showStatus(){
     String  status = gameProxy.getGameState();
     showText(status, 250, 554);
    }
    
    public boolean isPlayerPresent(){
     String  status = gameProxy.getGameState();
     //return status.equals("Game Started State");
     return true;
    }
    
    public void act()
    {
        if (!isPlayerPresent())
        {
            Message message = new Message("  Waiting for the players to join .     ");
            addObject(message, 400, 500);
            Greenfoot.delay(50);
            removeObject(message);
            message = new Message("  Waiting for the players to join ..    ");
            addObject(message, 400, 500);
            Greenfoot.delay(50);
            removeObject(message);
            message = new Message("  Waiting for the players to join ...   ");
            addObject(message, 400, 500); 
            Greenfoot.delay(50);
            removeObject(message);
        }
        else
        {
            Greenfoot.setWorld(new PlayWorld());
        }
    }
}
