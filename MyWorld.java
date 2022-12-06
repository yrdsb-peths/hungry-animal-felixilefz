import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MyWorld extends World
{
    public int appleCount = 0;
    private int difficultly;
    private int applesCaught = 0;
    private int applesMissed = 0;
    private Label counter;
    private Label hpCount;
    private Label scoreCount;
    private int hp;
    private int score;
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Elephant e = new Elephant();
        addObject(e, 100, 300);
        hp = 50;
        score = 0;
        counter = new Label("Caught: " + applesCaught + " Missed: " + applesMissed + "\n Score: " + score + " HP: " + hp, 40);
        addObject(counter, getWidth()/2, 40);
    }
    
    public void act() {
        if (hp <= 0) {
            Label gameover = new Label("Gameover" + "\n Total Score: " + score, 80);
            addObject(gameover, getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
        
        if (appleCount < 3) {
            if (Greenfoot.getRandomNumber(1 + appleCount*15) == 0) {
                addApple();
            }
        }
        
        difficultly = (applesCaught+10) / 10;
    }
    
    public void addApple() {
        Apple a = new Apple();
        addObject(a, Greenfoot.getRandomNumber(500) + 50, 10);
        appleCount ++;
    }
    
    public void missedApple() {
        applesMissed ++;
        hp -= 1 * difficultly;
        showStats();
    }
    
    public void caughtApple() {
        applesCaught ++;
        score += (int) (1.5*difficultly);
        hp ++;
        showStats();
    }
    
    public int getDifficultly() {
        return difficultly;
    }
    
    public void showStats() {
        counter.setValue("Caught: " + applesCaught  + " Missed: " + applesMissed + "\n Score: " + score + " HP: " + hp);
    }
}
