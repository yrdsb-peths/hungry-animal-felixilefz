import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{

    
    public void act() 
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + 1;
        setLocation(x, y);
    }    
    
    public int getY() {
        return super.getY();
    }
    

    
}
