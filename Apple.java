import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    private int dropSpeed;
    private MyWorld world;
    
    public Apple() {
        dropSpeed = Greenfoot.getRandomNumber(2)+1;
        GreenfootImage image = new GreenfootImage("images/apple.png");
        image.scale(28, 30);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
        world = (MyWorld) getWorld();
        int x = getX();
        int y = getY() + dropSpeed + world.getDifficultly()/2;
        setLocation(x, y);
        if (getY() > world.getHeight()) {
            world.missedApple();
            world.appleCount --;
            world.removeObject(this);
            
        }
    }    
}
