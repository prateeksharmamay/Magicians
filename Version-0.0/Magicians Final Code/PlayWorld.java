import greenfoot.*;  
import org.json.JSONArray;
import org.json.JSONObject;
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
    private WaitingScoreWorld waitingScoreWorld = WaitingScoreWorld.getInstance();
    //
    private Button startButton;
    private BackCurtain backCurtain;
    private FrontCurtain frontCurtain;
    private Grid grid;
    private Magician magician; 
    private NextButton nextButton;
    
    private SubmitScoreButton submitScoreButton;
    private GameProxy gameProxy;
     
    private GridDecorator deocratedGrid;
    private TimerActor timer = new TimerActor();
    
    public PlayWorld()
    {
        super(800, 600, 1);
        
        nextButton = new NextButton();        
        addObject(nextButton, 590, 490);
        
        submitScoreButton = new SubmitScoreButton();
        addObject(submitScoreButton, 620, 290);

        backCurtain = new BackCurtain(grid);
        addObject(backCurtain, 400, 300);
        
        setPaintOrder(NextButton.class, FrontCurtain.class, BackCurtain.class, Grid.class);
 
        frontCurtain = new FrontCurtain();
        addObject(frontCurtain, 400, 300);  
        
        backCurtain = new BackCurtain(grid);
        addObject(backCurtain, 400, 300); 
        
        addObject(new WorldSwitchButton("Menu", menuworld), 50, 500);
        
        gameProxy = new GameProxy();
        //addObject(new SubmitScoreButton(),620, 290);
        //addObject(new TestTimerbutton(timer), 550, 200);
    }
    
    
    public void setGrid(JSONObject serverGrid){
        grid = new Grid(5,this);
        try{
           
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
            
                    String key = "r"+i+"c"+j;
                    if(serverGrid.get(key).toString().equals("1")){
                        grid.cardGrid[i][j] = new Card(i,j);
                        grid.cardGrid[i][j].flipCard();
                        addObject(grid.cardGrid[i][j],250 /*165*/ + j * 60, 180 /*110*/ + i * 60);
                    }
                    else{
                        grid.cardGrid[i][j] = new Card(i,j);
                        addObject(grid.cardGrid[i][j], 250 /*165*/ + j * 60, 180 /*110*/ + i * 60);
                    }
                }
            }

        }
        
        catch(Exception e){
            
        }
        deocratedGrid = new GridDecorator(grid);
        addObject(deocratedGrid, 300, 100);
        magician = new Magician(deocratedGrid, nextButton, backCurtain);
        addObject(magician, 300, 550);
    }
    
    
    public void act() 
    {
       
            // setPaintOrder(Card.class,NextButton.class, FrontCurtain.class, BackCurtain.class);
            if(grid.isFlipped()
             && Greenfoot.getMouseInfo() !=null 
            && Greenfoot.getMouseInfo().getActor() !=null 
            && Greenfoot.getMouseInfo().getActor().getClass().equals(Card.class))
            {
                //System.out.println("some "+Greenfoot.getMouseInfo().getActor().getClass().toString());
                if(Greenfoot.mouseClicked(Greenfoot.getMouseInfo().getActor())){
                   Card card = (Card)Greenfoot.getMouseInfo().getActor();
                    grid.selectCard(card);
                   System.out.println();
                   System.out.println("select card is at "+card.row+" "+card.col);
                   Card magicianPickedCard = magician.trick();
                   if(magicianPickedCard.col == card.col && magicianPickedCard.row == card.row)
                   {
                    System.out.println("^^^^^ !!!!! YOU WON !!!!! ^^^^^");
                    }
                    else{
                    System.out.println("YOU LOST");
                    }
                    
                    submitScore();
                }
            }
            
            if(Greenfoot.getMouseInfo() !=null 
            && Greenfoot.getMouseInfo().getActor() !=null 
            && Greenfoot.getMouseInfo().getActor().getClass().equals(SubmitScoreButton.class))
            {
                //if(Greenfoot.mouseClicked(Greenfoot.getMouseInfo().getActor().getClass().equals(SubmitScoreButton.class))){
                System.out.println("^Cliecked Submittt");
                //}
                
               System.out.println("i dont knowwww wsubmitttt");
            
            }
            
        }
         
    public void submitScore(){
    // shall be a post request
    
        gameProxy.submitScore("Player","12", "correct");
        Greenfoot.setWorld(this.waitingScoreWorld);
    }
        
        
    public NextButton getNextButton()
    {
        return nextButton;
    }

    public Button getButton()
    {
        return startButton;
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
