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
    private String stage;
    public TestTimerbutton(TimerActor t){
        this.t = t;
        this.image = this.hoverImage = onPressImage = new GreenfootImage("rocket.png");
        this.stage = "game start";
        setImage(image);
    }
    public void act() 
    {
        mouseAction();
        if(stage =="wait for player")
        {
            //do nothing but wait for the game start
        }
        if(stage == "game start"){

     
            //display instruction and expending grid --> move stage to "grid expend"
        }
        if(stage == "grid expend"){
            //curtain down and flip the card
        }
        if(stage == "guess stage"){
            //player make a guess when click button to
        }
        if(Greenfoot.mouseClicked(this)){
            System.out.println(this.getClass().toString() +"clicked");
          if(t.getStatus() == false){
              t.start();
           }else{
               t.stopTimer();
               ///setImage(new GreenfootImage(new Integer(t.getElapseTime()).toString(), 25, null,null));
            }
         
        }
    }
   public void setStage(String stage){
       this.stage = stage;
    }
}
