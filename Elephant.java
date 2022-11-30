import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{
    private double speed = 0;
    private int speedCap = 8;
    
    public void act() 
    {
       // kind of makes it slippery
       
       if (Math.abs(speed) < speedCap) {
           
           if (Greenfoot.isKeyDown("d")) {
               speed += 0.5;
           }
           
           if (Greenfoot.isKeyDown("a")) {
               speed -= 0.5;
           }

       }
        
       if (speed < 0) {
           speed += 0.1;
       }
           
       if (speed > 0) {
           speed -=0.1;
       }
       move((int)speed);
       eat();
    }    
    
    public void eat() {
        if (isTouching(Apple.class)) {
            removeTouching(Apple.class);
            ((MyWorld) getWorld()).addApple();
            ((MyWorld) getWorld()).appleCount --;
        }
         
    }
}
