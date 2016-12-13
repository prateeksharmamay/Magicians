import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester extends Actor
{
    public Tester()
    {       
    }
    
    public void act() 
    {     
    }
    
    //Test if the back curtain can move down
    public void testBackCurtainDown()
    {
        PlayWorld playWorld= (PlayWorld) getWorld();
        BackCurtain backCurtain = playWorld.getBackCurtain();
        backCurtain.animationDown();
    }
    
    //Test if the back curtain can move up
    public void testBackCurtainUp()
    {
        PlayWorld playWorld = (PlayWorld) getWorld();
        BackCurtain backCurtain = playWorld.getBackCurtain();
        backCurtain.animationUp();
    }
    
    //Test the button status
    public void testButtonStatus()
    {
        PlayWorld playWorld = (PlayWorld) getWorld();
        Button button = playWorld.getButton();
        System.out.println(button.getStarted());
        button.setStarted(true);
        System.out.println(button.getStarted());
    }
}
