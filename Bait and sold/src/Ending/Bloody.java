package Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Bloody extends JPanel
{
    private List<Point2D> spillblood = new ArrayList<>();

    public void decorate()
    {
        randomblood manydots = new randomblood();
        Thread a = new Thread(manydots);
        a.start();
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        for (Point2D bloodpos : spillblood)
        {
            g.setColor(Color.RED);
            g.fillOval((int) bloodpos.getX(), (int) bloodpos.getY(), 50, 100); //the circle red spots are drawn
        }
    }

    class randomblood implements Runnable
    {
        public void run()
        {
            while(spillblood.size()<1000)
            {
                for (int i = 0; i < 10; i++)
                {
                    int x = (int) (Math.random() * 1280);
                    int y = (int) (Math.random() * 800);

                    spillblood.add(new Point2D.Double(x, y)); //add points randomly
                }
                try
                {
                    Thread.sleep(158);
                } catch (InterruptedException e){Thread.interrupted();}
                repaint(); //bloody ending
            }
        }
    }
}
