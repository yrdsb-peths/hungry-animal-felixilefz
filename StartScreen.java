import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Label titleScreen = new Label("Hungry Animal", 100);
         
        titleScreen.setFillColor(Color.RED);
        addObject(titleScreen, getWidth()/2, getHeight()/4);
        Button play = new Button(new MyWorld(), 200, 100, new GreenfootImage("images/play_button.png"));
        addObject(play, getWidth()/2, getHeight()/2 + 20);
    }
    
    public void prepare() {
        
    }
}
