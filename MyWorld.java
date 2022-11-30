import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MyWorld extends World
{
    // private ArrayList<Apple> appleList = new ArrayList<Apple>();
    public int appleCount = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Elephant e = new Elephant();
        addObject(e, 100, 300);
        addApple();
        
    }
    
    public void act() {
        if (appleCount < 3) {
            if (Greenfoot.getRandomNumber(3) == 0) {
                addApple();
            }
        }
    }
    
    public void deleteApple(Apple a) {
        removeObject(a);
        addApple();
    }
    
    public void addApple() {
        Apple a = new Apple();
        addObject(a, Greenfoot.getRandomNumber(500) + 50, 10);
        appleCount ++;
    }
}
