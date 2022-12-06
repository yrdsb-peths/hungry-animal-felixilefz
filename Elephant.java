import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{
    private double speed = 0;
    private int speedCap = 8;
    private MyWorld world;
    private GreenfootImage[] idleRight = new GreenfootImage[8];
    private GreenfootImage[] idleLeft = new GreenfootImage[8];
    private int animationIndex = 0;
    private String animationState;
    
    public Elephant() {
        for (int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
        for (int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
        }
        setImage(idleRight[0]);
        animationState = "right";
    }
    
    
    public void act() 
    {
       // kind of makes it slippery
       world = (MyWorld) getWorld();
       if (Math.abs(speed) < speedCap) {
           
           if (Greenfoot.isKeyDown("d")) {
               speed += 0.5;
           }
           
           if (Greenfoot.isKeyDown("a")) {
               speed -= 0.5;
           }

       }
       
       // if the speed is not 0 your speed decreases slowly. Also changes animations states
       if (speed < 0) {
           speed += 0.1;
           animationState = "left";
       }
           
       if (speed > 0) {
           speed -=0.1;
           animationState = "right";
       }
       move((int)speed);
       eat();
       animate();
    }    
    
    public void eat() {
        if (isTouching(Apple.class)) {
            removeTouching(Apple.class);
            world.caughtApple();
            world.appleCount --;
        }
         
    }
    
    public void animate() {
        if (animationState == "right") {
            animationIndex = (animationIndex + 1) % idleRight.length;
            setImage(idleRight[animationIndex]);
            animationIndex ++;
        } else if (animationState == "left") {
            animationIndex = (animationIndex + 1) % idleLeft.length;
            setImage(idleLeft[animationIndex]);
            animationIndex ++; 
        }
        
    }
}
