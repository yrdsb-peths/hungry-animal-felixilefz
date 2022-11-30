import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    private int dropSpeed;

    
    public Apple() {
        dropSpeed = Greenfoot.getRandomNumber(3)+3;
    }
    
    public void act() 
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + dropSpeed;
        setLocation(x, y);
        if (isAtEdge()) {
            ((MyWorld) getWorld()).deleteApple(this);
        }
    }    
    
    public int getY() {
        return super.getY();
    }
    

    
}
