import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
    private static int highScore = 0;
    
    
    
    public GameOverScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        if (score > highScore) {
            highScore = score;
        }
        Label gameover = new Label("Gameover" + "\nTotal Score: " + score + "\nHigh Score: " + highScore, 80);
        addObject(gameover, getWidth()/2, getHeight()/2);
        
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
           StartScreen world = new StartScreen();
           Greenfoot.setWorld(world);
       }
    }
    
}
