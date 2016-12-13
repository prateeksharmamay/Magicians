import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.json.JSONObject;
/**
 * Write a description of class IGameProxy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IGameProxy {
    public void addPlayer(String userName);
    public String getGameState();
    public JSONObject getGrid();
    public void submitScore(String username, String score, String userResult);
    public String getScores();
       
}
