import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextButton extends Actor
{
    private boolean pressed;

    public NextButton()
    {
        pressed = false;
    }

    public void act() 
    {        
        if (Greenfoot.mouseClicked(this)){
            pressed = true;
            System.out.println("  butttons is gerttign preseed ");
            PlayWorld  playWorld = (PlayWorld) getWorld();
            Magician magician =  playWorld.getMagician();
            magician.operateGrid();
        }
    }

    public boolean isPressed()
    {
        return pressed;
    }
    
    public void setPressed(boolean pressedOrNot) {
        pressed = false;
    }

}
