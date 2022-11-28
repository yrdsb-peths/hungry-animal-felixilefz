import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{

    public void act() 
    {
       
       MouseInfo m = Greenfoot.getMouseInfo();
       // System.out.println(m);
       
       if (m == null || (getX() == m.getX() && getY() == m.getY())) {
           return;
       }
       
       turnTowards(m.getX(), m.getY());
       move(1);
    }    
}
