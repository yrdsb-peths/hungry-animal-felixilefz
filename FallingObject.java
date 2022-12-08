import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallIngObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObject extends Actor
{
    // This class is usless for now
    // this may be used when more falling objects are added
    
    // 
    int dropSpeed;
    
    public FallingObject() {
         dropSpeed = Greenfoot.getRandomNumber(2)+1;
    }
    
    public void act() 
    {
       MyWorld world = (MyWorld) getWorld();
       setLocation(getX(), getY()+dropSpeed);
       if (getY() > world.getHeight()) {
           world.removeObject(this);
       }
    }
    
    
}
