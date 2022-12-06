import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    private int dropSpeed;
    private MyWorld world;
    
    public Apple() {
        dropSpeed = Greenfoot.getRandomNumber(3)+3;
    }
    
    public void act() 
    {
        // Add your action code here.
        world = (MyWorld) getWorld();
        int x = getX();
        int y = getY() + dropSpeed;
        setLocation(x, y);
        if (isAtEdge()) {
            world.missedApple();
            world.appleCount --;
            world.removeObject(this);
            
        }
    }    
}
