import greenfoot.*;  

/**
 * class Button will show a button "Start" on the screen. Once the button is
 * hitted, the animation will start. 
 * 
 * @author (Chen Shi) 
 * @version 1.0
 *
 * We ahve added a NextButton class also in this project, its role is to navigate 
 * in the game, from expanding the grid to doing animation. The next Button class has a 
 * rocket icon.
 */
public class Button extends Actor
{
    private boolean mouseDown;
    private boolean started;
    private static GreenfootImage button1 = new GreenfootImage("start1.png");
    private static GreenfootImage button2 = new GreenfootImage("start2.png");
    
    public Button()
    {
        setImage(button1);
        mouseDown = false;
        started = false;
    }

    public void act() 
    {        
        if (!mouseDown && Greenfoot.mousePressed(this))
        {
            setImage(button2);
            mouseDown = true;
        }
        
        if (mouseDown && Greenfoot.mouseClicked(this))
        {
            setImage(button1);
            mouseDown = false;
            started = true;
        }    
    }
    
    public boolean getStarted()
    {
        return started;
    }
    
    public void setStarted(boolean startedOrNot)
    {
        started = startedOrNot;
    }
}
