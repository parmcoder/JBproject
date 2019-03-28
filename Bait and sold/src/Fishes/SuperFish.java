package Fishes;

import javax.swing.*;
import java.awt.*;


public class SuperFish extends EasyFish
{
    public SuperFish(int x, int y)
    {
        super(x, y);
        supermode(); //there are variables that superfish are different from normal fishes
        SuperSplashing splashing = new SuperSplashing(this); //special thread for super fish
        Thread movable2 = new Thread(splashing);
        movable2.start(); //it will try to runaway from the bucket
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        Image image = new ImageIcon("Pic_lib/kisspng-goldfish-real-fish-png.png").getImage();
        g.drawImage(image, getFishx(), getFishy(), position); //draw the cool super fish
    }

    class SuperSplashing implements Runnable
    {
        int x;
        int y;
        private SuperFish fish;
        int deltax;
        int deltay;

        SuperSplashing(SuperFish f)
        {
            x = f.getFishx();
            y = f.getFishy();
            deltax = 10;
            deltay = 7;
            fish = f;
        }

        public void run() {
            while (fish.isFishcanmove() && (x<1100) && (y>100))
            {
                y -= deltay;
                x += deltax;
                fish.setFishLocation(x, y);
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}


            }
        }
    }
}

