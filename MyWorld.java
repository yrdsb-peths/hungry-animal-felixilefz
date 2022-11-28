import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MyWorld extends World
{
    private ArrayList<Apple> appleList = new ArrayList<Apple>();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Elephant e = new Elephant();
        
        addObject(e, 100, 300);
        
        
    }
    
    public void act() {
        // instead of deleting teleport it back 
        if (appleList.size() < 5) {
            Apple apple = new Apple();
            int x = Greenfoot.getRandomNumber(500) + 50;
            addObject(apple, x, 10);
            appleList.add(apple);
        }
        
        
        for (int i = 0; i < appleList.size(); i++) {
            if (appleList.get(i).getY()+10 >= getHeight()) {
                // can use isAtEdge;
                removeObject(appleList.remove(i));
                i --;
            }
        }
    }
}
