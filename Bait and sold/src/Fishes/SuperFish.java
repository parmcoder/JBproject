package Fishes;

import javax.swing.*;
import java.awt.*;


public class SuperFish extends EasyFish {
    private int Sensitivity = 20;

    public SuperFish(int x, int y) {
        super(x, y);
        supermode();
        SuperSplashing splashing = new SuperSplashing(this);
        Thread movable = new Thread(splashing);
        movable.start(); //fix here
    }



    public void paintComponent(Graphics g) // this will be called automatically
    {
        Image image = new ImageIcon("Pic_lib/kisspng-goldfish-real-fish-png.png").getImage();

        // Image image = new ImageIcon("/home/parmcoder/gjbfish/JBproject/Bait and sold/src/unshi.jpg").getImage();
        g.drawImage(image, getFishx(), getFishy(), position);
        //g.setColor(Color.BLUE);
        // g.fillRect(getFishx(),getFishy(),50,50);
    }

    class SuperSplashing implements Runnable {
        int x;
        int y;
        SuperFish fish;
        int deltax;
        int deltay;

        SuperSplashing(SuperFish f) {
            x = f.getFishx();
            y = f.getFishy();
            deltax = f.Sensitivity;
            deltay = f.Sensitivity;
            fish = f;
        }

        public void run() {
            while (fish.canmove) {
                for(int i = 0; i<3; i++){
                    x += deltax;
                    fish.setFishLocation(x, y);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                for(int i = 0; i<3; i++){
                    y += deltay;
                    fish.setFishLocation(x, y);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }

                for(int i = 0; i<3; i++){
                    x -= deltax;
                    fish.setFishLocation(x, y);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }

                for(int i = 0; i<3; i++){
                    y -= deltay;
                    fish.setFishLocation(x, y);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
