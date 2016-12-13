import greenfoot.*;  

/**
 * class Senario will set up the curtains and show an animation when
 * "Start" button is clicked.
 * 
 * @author (Chen Shi) 
 * @version 1.0
 */

public class PlayWorld extends World
{
    //get worlds
    private Main menuworld = Main.getInstance();
    private TheoryWorld theoryworld = TheoryWorld.getInstance();
    private RankboardWorld rankworld = RankboardWorld.getInstance();
    private DemoWorld demoworld = DemoWorld.getInstance();
    private BackCurtain backCurtain;
    private FrontCurtain frontCurtain;
    private Grid grid;
    private Magician magician; 
    private TimerActor timer = new TimerActor();
    private PlayerWorldButton p_btn = new PlayerWorldButton(timer);
    
    
    public PlayWorld()
    {
        super(800, 600, 1);
        grid  = new Grid(5, this);
        GridDecorator deocratedGrid = new GridDecorator(grid);
        addObject(deocratedGrid, 300, 100);
  
        
      
        addObject(p_btn, 590, 490);

        backCurtain = new BackCurtain(grid);
        addObject(backCurtain, 400, 300); 

        GridProxy gridProxy = new GridProxy(deocratedGrid);
        magician = new Magician(gridProxy/*, nextButton*/, backCurtain);
        addObject(magician, 300, 550);
        
        //deocratedGrid.expandGrid();
        
        //addObject(magician, 550, 550);
        /*magician.fillErrorDetection();
        
        /*grid.flipRandomly();
        magician.trick();*/
        
        setPaintOrder(ActionButton.class, FrontCurtain.class, BackCurtain.class, Grid.class);
 
        frontCurtain = new FrontCurtain();
        addObject(frontCurtain, 400, 300);  
        
        backCurtain = new BackCurtain(grid);
        addObject(backCurtain, 400, 300); 
        
        addObject(new WorldSwitchButton("Menu", menuworld), 50, 500);
    }
    
    
    
    public void act() 
    {
        if(p_btn.getStage() == "guess stage")
        {
            // setPaintOrder(Card.class,NextButton.class, FrontCurtain.class, BackCurtain.class);
            if(grid.isFlipped()&& Greenfoot.getMouseInfo().getActor() !=null && Greenfoot.getMouseInfo().getActor().getClass().equals(Card.class)){
                System.out.println(Greenfoot.getMouseInfo().getActor().getClass().toString());
                if(Greenfoot.mouseClicked(Greenfoot.getMouseInfo().getActor())){
                   grid.selectCard((Card)Greenfoot.getMouseInfo().getActor());
                }
            }
           
        }
        if(p_btn.getStage() == "complete guess"){
            Player.object.setResult(grid.getGuessResult());
            System.out.print("result:");
            System.out.println(Player.object.getResult());
            Greenfoot.setWorld(DemoWorld.getInstance());
        }
    
    }
    
    public PlayerWorldButton getButton()
    {
        return p_btn;
    }
    
    public BackCurtain getBackCurtain()
    {
        return backCurtain;
    }
    
    public FrontCurtain getFrontCurtain()
    {
        return frontCurtain;
    }
    
    public Grid getGrid()
    {
        return grid;
    }
    
    public Magician getMagician()
    {
        return magician;
    }
}
