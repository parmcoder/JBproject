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
        movable.start(); //fix here

    }

    public int getFishx(){
        return this.XofFish;
    }

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
    }
    public void caught(EasyFish f){
        f.canmove = false;
    }

    public int getFishy(){
        return this.YofFish;
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        Image image = new ImageIcon("Pic_lib/kisspng-goldfish-real-fish-png.png").getImage();

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
            while(fish.canmove){

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
