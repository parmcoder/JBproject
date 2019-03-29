package Fishes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

public class EasyFish {
    //these are the properties of the easyfish,
    // some are not instance variables.
    private int XofFish = 0;
    private int YofFish = 0;
    private Random ran = new Random();
    private int Sensitivity = ran.nextInt(10)+1;
    private int special = 0;
    private Boolean Buyable = true;
    Boolean canmove = true;
    ImageObserver position;

    public EasyFish(int x, int y) //when called, EasyFish set up its position
    {
        this.XofFish = x;   //This is why I need to use Point2D,
        this.YofFish = y;   //I need the position from Point2D to create them fishes.
                            //it behaves like fish, it moves around when created on the screen

        Splashing splashing = new Splashing(this);
        Thread movable = new Thread(splashing);
        movable.start();
    }

    public int getFishx(){
        return this.XofFish;
    }
    public int getFishy(){
        return this.YofFish;
    }

    public void setFishx(int i)
    {
        this.XofFish = i;
    }
    public void setFishy(int i)
    {
        this.YofFish = i;
    }

    public void setFishLocation(int x, int y)
    {
        this.XofFish = x;
        this.YofFish = y;
    }

    public void setBought(){this.Buyable = false;}

    public boolean isFishsuper()    //When the fish is not normal,
                                    // we need to know if it is superfish or not?
    {
        if(this.special == 1){return true;}
        else{return false;}

    }

    public Boolean isBuyable(){return this.Buyable;}
    public Boolean isFishcanmove(){return this.canmove;}

    public void caught(EasyFish f)  //When a fish is caught, most of them stop moving because of the shock
                                    //except the superfish, it knows what to do, swim away from the bucket
    {
        f.canmove = false;
        if(f.isFishsuper()){supermove();}
    }

    public void supermode(){this.special =1; }
    //setting up the properties
    public void supermove(){this.canmove = true;}
    //only used when the fish is super
    public void supercaught(EasyFish f){f.canmove = false;}
    //What ever the fish is, we will supercatch it lol. We are the strongest in our game after all.

    public void paintComponent(Graphics g)
    // this will be called in the panel
    {
        Image image = new ImageIcon("Pic_lib/gigantic-cartoons-of-fish-derp-by-fercho262-on-deviantart-1024x532.png").getImage();
        g.drawImage(image, getFishx(), getFishy(), position); //draw that image there
    }

    class Splashing implements Runnable //how the fish move before being caught
    {
        int x;
        int y;
        EasyFish fish;
        int deltax;
        int deltay;

        Splashing(EasyFish f)
        {
            x = f.getFishx();
            y = f.getFishy();
            deltax = f.Sensitivity;     //if you check the properties, each fish has different
            deltay = f.Sensitivity;     //sensitivity, resulting in different movement
            fish = f;                   //but the patterns are the same
        }

        public void run(){
            while(isFishcanmove() && (isFishsuper()==false))
                //actually all fishes can run this, but superfish can't.
            {
                x+=deltax;
                y+=deltay;
                fish.setFishLocation(x,y);
                try{
                    Thread.sleep(300);}catch(InterruptedException e){}

                x-=deltax;
                fish.setFishLocation(x,y);
                try{
                    Thread.sleep(300);}catch(InterruptedException e){}

                y-=deltay;
                fish.setFishLocation(x,y);
                try{
                    Thread.sleep(300);}catch(InterruptedException e){}
            }
        }
    }
}
