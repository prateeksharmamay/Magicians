import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class WorldSwithButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldSwitchButton extends ActionButton
{

    private World world;
    private String title;
	/**
	 * WorldSwitchButton - class constructor
	 * @param title - String of button image name, make should it has additional images for "<Title>_highlight.png" and "<Title>_OnPress.png"
	 * @param w - A World object that this button will navigate to 
	 */
    public WorldSwitchButton(String title, World w){
        this.world = w;
        this.title=title;
        this.image = new GreenfootImage(title+".png");
		this.hoverImage = new GreenfootImage(title+"_highlight.png");
 		this.onPressImage = new GreenfootImage(title+"_OnPress.png");
        setImage(this.image);
    }
     /**
     * Act - animate clicking action and click button will going to the target world.
     */
    public void act() 
    {
        // Add your action code here.
		mouseAction();
        if(Greenfoot.mouseClicked(this)){
          System.out.println(title +"clicked");

          Greenfoot.setWorld(this.world);
        }
    }    
}
