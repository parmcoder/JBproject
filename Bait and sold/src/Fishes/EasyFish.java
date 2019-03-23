package Fishes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class EasyFish {
    private int XofFish = 0;
    private int YofFish = 0;
    private Image image = new ImageIcon("/home/parmcoder/gjbfish/JBproject/Bait and sold/src/unshi.jpg").getImage();

    public EasyFish(int x, int y){
        this.XofFish = x;
        this.YofFish = y;
    }

    public int getFishx(){
        return this.XofFish;
    }

    public int setFishx(int i)
    {
        this.XofFish = i;
        return this.XofFish;
    }

    public int getFishy(){
        return this.YofFish;
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
       // Image image = new ImageIcon("/home/parmcoder/gjbfish/JBproject/Bait and sold/src/unshi.jpg").getImage();
       // g.drawImage(image, getFishx(), getFishy(), (ImageObserver) this);
        g.setColor(Color.BLUE);
        g.fillRect(getFishx(),getFishy(),50,50);
    }

}
