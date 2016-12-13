import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.TreeMap;
import java.util.Map;

/**
 * Write a description of class RankboardWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RankboardWorld extends World
{
    private static RankboardWorld rbworld = null;
    private String rankBoardServerUrl;
    private GameProxy gameProxy;
    private String result;
    // private TreeMap<Integer, String> rankBoard;
    private IRankingitem board = new RankingItemRoot();
    /**
     * Constructor for objects of class RankboardWorld.
     * 
     */
    public RankboardWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground(new GreenfootImage("background5.jpg"));
        rbworld = this;
        addObject(new WorldSwitchButton("Menu", Main.getInstance()).withSize(100,55),100,350);
        addObject(new WorldSwitchButton("Theory",TheoryWorld.getInstance()).withSize(100,55),250,350);
        addObject(new WorldSwitchButton("Play", new PlayWorld()).withSize(100,55),400,350);
        //showText("This will be Rankboard", 200, 100);
        rankBoardServerUrl = "http://some_valid_aws_url.com";
        //rankBoard = new TreeMap<Integer, String>();
        fetchRankerBoard();
        displayRankBoard();
        gameProxy = new GameProxy();
        
        result = gameProxy.getScores();
    }
    
    public static RankboardWorld getInstance(){
        if( rbworld == null)
            new RankboardWorld();
        return rbworld;
    }
    
    public void fetchRankerBoard()
    {
        /*
           will use rankBoardServerUrl to make request 
           & fill the rank hashmap with the response
           as of now filling with stubbed data
           */
            // rankBoard.put(5,"Carlos");
            // rankBoard.put(7,"Chen");
            // rankBoard.put(8,"Miau");
            // rankBoard.put(13,"Prateek");          
            // rankBoard.put(15,"Jayam");
            /*board.addItem(new RankingItemLeaf(1,"Carlos","1000"));
            board.addItem(new RankingItemLeaf(2,"Chen","999"));
            board.addItem(new RankingItemLeaf(3,"Miao","998"));
            board.addItem(new RankingItemLeaf(4,"Prateek","997"));
            board.addItem(new RankingItemLeaf(5,"Jayam","996"));
            board.addItem(new RankingItemLeaf(6,"Carlos","1000"));
            board.addItem(new RankingItemLeaf(7,"Chen","999"));
            board.addItem(new RankingItemLeaf(8,"Miao","998"));
            board.addItem(new RankingItemLeaf(9,"Prateek","997"));
            board.addItem(new RankingItemLeaf(10,"Jayam","996"));*/
            
            System.out.println(result);

            
        }
    
    public void displayRankBoard()
    {
        // //showText("This will be Rankboard", 200, 100);
        // int i=0;
        
        // showText("Player - Score", 200, 70);
        // for (Map.Entry<Integer, String> rank: rankBoard.entrySet()) 
        // {    
            // String name = rank.getValue();
            // Integer score = rank.getKey();
            // showText(name+" - "+score, 200, 100 + i*20);
            // i++;
        // }
        board.display(300,70);
    }
}
