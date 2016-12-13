import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DemoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoWorld extends World
{

    /**
     * Constructor for objects of class DemoWorld.
     * 
     */
    private static DemoWorld demoworld = null;
    private TimerActor timer = new TimerActor();
    public DemoWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.demoworld = this;
        addObject(new WorldSwitchButton("Menu", Main.getInstance()),50,50);
        addObject(timer, 200,100);
        addObject(new TestTimerbutton(timer), 350, 200);
        showText("this will be demoworld", 250, 30);
    }
    
    public static DemoWorld getInstance(){
        if( demoworld == null){
            new DemoWorld();
        }
        return demoworld;
    }
}
