package Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bloody extends JPanel {
    private List<Point2D> spillblood = new ArrayList<>();


    public void decorate()
    {
      /*  if(wait == 500){ spillblood.removeAll(spillblood);
            for (int i = 0; i < 20; i++) {
                int x = (int) (Math.random() * 1280);
                int y = (int) (Math.random() * 800);

                spillblood.add(new Point2D.Double(x, y));
                wait =0;
        }
        }
        wait++;
        return spillblood;*/
        randomblood manydots = new randomblood();
        Thread a = new Thread(manydots);
        a.start();

    }


    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        //   int time = 0;
        //  time++;
        //    if(time > 10){
        for (Point2D bloodpos : spillblood) {
        //    int red = (int) (Math.random() * 255);
        //    int green = (int) (Math.random() * 255);
       //     int blue = (int) (Math.random() * 255);
           // Color randomColor = new Color(red, green, blue);
            g.setColor(Color.RED);
            g.fillOval((int) bloodpos.getX(), (int) bloodpos.getY(), 50, 100);
        }
    }
    //    time=0;
    class randomblood implements Runnable{
        public void run(){
            while(spillblood.size()<1000) {

                for (int i = 0; i < 10; i++) {
                    int x = (int) (Math.random() * 1280);
                    int y = (int) (Math.random() * 800);

                    spillblood.add(new Point2D.Double(x, y));
                }

                try {
                    Thread.sleep(158);
                } catch (InterruptedException e) { Thread.interrupted();
                }

                repaint();
                // System.out.println("new");
            }

        }
    }
}
