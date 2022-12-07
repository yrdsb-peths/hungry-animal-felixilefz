import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{
    private double speed = 0;
    private int speedCap = 8;
    private SimpleTimer animationTimer = new SimpleTimer(); 
    private GreenfootImage[] idleRight = new GreenfootImage[8];
    private GreenfootImage[] idleLeft = new GreenfootImage[8];
    private int animationIndex = 0;
    private String animationState;
    
    public Elephant() {
        for (int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(50, 50);
        }
        for (int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(50, 50);
        }
        setImage(idleRight[0]);
        animationState = "right";
    }
    
    
    public void act() 
    {
       // kind of makes it slippery
       MyWorld world = (MyWorld) getWorld();
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
       // if the elephant moves too far offscreen it will cancel the movement
       if (getX() < -30 || getX() > world.getWidth()+30) {
           move((int) speed * -1);
       }
       eat();
       animate();
    }    
    
    public void eat() {
        MyWorld world = (MyWorld) getWorld();
        if (isTouching(Apple.class)) {
            removeTouching(Apple.class);
            world.caughtApple();
            world.appleCount --;
        }
         
    }
    
    public void animate() {
        if (animationTimer.millisElapsed() > 100) {
            if (animationState == "right") {
                animationIndex = (animationIndex + 1) % idleRight.length;
                setImage(idleRight[animationIndex]);
                animationIndex ++;
            } else if (animationState == "left") {
                animationIndex = (animationIndex + 1) % idleLeft.length;
                setImage(idleLeft[animationIndex]);
                animationIndex ++; 
            }
            animationTimer.mark();
        }
        
    }
}
