import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestTimerbutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestTimerbutton extends ActionButton
{
    private TimerActor t;
    public TestTimerbutton(TimerActor t){
        this.t = t;
        this.image = this.hoverImage = onPressImage = new GreenfootImage("rocket.png");
        setImage(image);
    }
    public void act() 
    {
        mouseAction();
        if(Greenfoot.mouseClicked(this)){
            System.out.println(this.getClass().toString() +"clicked");
          if(t.getStatus() == false){
              t.start();
           }else{
               t.stopTimer();
               
               
               setImage(new GreenfootImage(new Integer(t.getElapseTime()).toString(), 25, null,null));
            }
         
        }
    }
    
}
