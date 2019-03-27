package Fishes;

import GameLauncher.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

public class EasyFish {
    private int XofFish = 0;
    private int YofFish = 0;
    private Random ran = new Random();
    private int Sensitivity = ran.nextInt(10);
    private int special = 0;
    private Boolean Buyable = true;

    Boolean canmove = true;
    ImageObserver position = new ImageObserver() {
        @Override
        public boolean imageUpdate(Image image, int i, int i1, int i2, int i3, int i4) {
            return false;
        }
    };

    public EasyFish(int x, int y){
        this.XofFish = x;
        this.YofFish = y;

        Splashing splashing = new Splashing(this);
        Thread movable = new Thread(splashing);
        movable.start();
        //movable.start(); }//fix here


    }

    public int getFishx(){
        return this.XofFish;
    }

    public boolean isFishsuper(){
        if(this.special == 1){return true;}
        else{return false;}

    }

    public void supermode(){this.special =1; }

    public void setBought(){this.Buyable = false;}
    public Boolean isBuyable(){return this.Buyable;}

    public void setFishx(int i)
    {
        this.XofFish = i;
    }
    public void setFishy(int i)
    {
        this.YofFish = i;
    }

    public void setFishLocation(int x, int y){
        this.XofFish = x;
        this.YofFish = y;
    }

    public void caught(){
        this.canmove = false;
        if(this.isFishsuper()){supermove();}
    }
    public void caught(EasyFish f){
        f.canmove = false;
        if(f.isFishsuper()){supermove();}
    }
    public void supermove(){
        this.canmove = true;
    }
    public void supercaught(){
        this.canmove = false;
    }

    public int getFishy(){
        return this.YofFish;
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        Image image = new ImageIcon("Pic_lib/gigantic-cartoons-of-fish-derp-by-fercho262-on-deviantart-1024x532.png").getImage();

        // Image image = new ImageIcon("/home/parmcoder/gjbfish/JBproject/Bait and sold/src/unshi.jpg").getImage();
        g.drawImage(image, getFishx(), getFishy(), position);
        //g.setColor(Color.BLUE);
       // g.fillRect(getFishx(),getFishy(),50,50);
    }

    class Splashing implements Runnable{
        int x;
        int y;
        EasyFish fish;
        int deltax;
        int deltay;

        Splashing(EasyFish f){
            x = f.getFishx();
            y = f.getFishy();
            deltax = f.Sensitivity;
            deltay = f.Sensitivity;
            fish = f;
        }
        public void run(){
            while(fish.canmove && (isFishsuper()==false)){

                x+=deltax;
                y+=deltay;
                fish.setFishLocation(x,y);

                try{
                    Thread.sleep(5);}catch(InterruptedException e){}
                x-=deltax;
                fish.setFishLocation(x,y);

                try{
                    Thread.sleep(10);}catch(InterruptedException e){}
                y-=deltay;
                fish.setFishLocation(x,y);

                try{
                    Thread.sleep(10);}catch(InterruptedException e){}
            }
        }
    }

}
