import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AnimationWorld extends World
{
    private GreenfootSound mySound = new GreenfootSound("My Song.mp3");
    private GreenfootImage[] images = new GreenfootImage[41];
    private int imageNumber;
    private int counter;
    private boolean notPlayed;
    
    public AnimationWorld()
    {    
        super(800, 600, 1); 
        for(int i = 0; i < images.length; i++) 
        {
            images[i] = new GreenfootImage("H" + i + ".jpg");
        }
        counter = 0;
        notPlayed = true;
    }
    
    public void act()
    {
        if (notPlayed) {animation();}
        else {Greenfoot.setWorld(new Main());}
    }
    
    public void animation()
    {
        if (counter % 18 == 0)
        {
            mySound.play();
            imageNumber = (imageNumber + 1) % images.length;
            setBackground(images[imageNumber]);
            
            if(imageNumber == images.length - 1)
            {notPlayed = false;}
        }
        counter++;
    }
}

