package Fishes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

public class EasyFish {
    private int XofFish = 0;
    private int YofFish = 0;
    private Random ran = new Random();
    private int Sensitivity = ran.nextInt(10)+1;
    private int special = 0;
    private Boolean Buyable = true;
    Boolean canmove = true;
    ImageObserver position;

    public EasyFish(int x, int y)
    {
        this.XofFish = x;
        this.YofFish = y;

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

    public boolean isFishsuper()
    {
        if(this.special == 1){return true;}
        else{return false;}

    }
    public Boolean isBuyable(){return this.Buyable;}
    public Boolean isFishcanmove(){return this.canmove;}

    /*public void caught(){ this is my prototype code
        this.canmove = false;
        if(this.isFishsuper()){supermove();}
    }*/

    public void caught(EasyFish f)
    {
        f.canmove = false;
        if(f.isFishsuper()){supermove();}
    }

    public void supermode(){this.special =1; }
    public void supermove(){this.canmove = true;}
    public void supercaught(EasyFish f){f.canmove = false;}

    public void paintComponent(Graphics g) // this will be called in the panel
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
            deltax = f.Sensitivity;
            deltay = f.Sensitivity;
            fish = f;
        }

        public void run(){
            while(isFishcanmove() && (isFishsuper()==false))
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
