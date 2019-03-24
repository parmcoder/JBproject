package Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class Congrats extends JPanel {
    private List<Point2D> spillblood = new LinkedList<Point2D>();
    int wait = 499;

    public List<Point2D> randomplace()
    {
        if(wait == 500){ spillblood.removeAll(spillblood);
            for (int i = 0; i < 20; i++) {
                int x = (int) (Math.random() * 1280);
                int y = (int) (Math.random() * 800);

                spillblood.add(new Point2D.Double(x, y));
                wait =0;
        }
        }
        wait++;
        return spillblood;
    }


    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        //   int time = 0;
        //  time++;
        randomplace();
        //    if(time > 10){
        for (Point2D bloodpos : spillblood) {
            g.setColor(Color.blue);
           // int red = (int) (Math.random() * 255);
           // int green = (int) (Math.random() * 255);
           // int blue = (int) (Math.random() * 255);
           // Color randomColor = new Color(red, green, blue);
           // g.setColor(randomColor);
            g.fillOval((int) bloodpos.getX(), (int) bloodpos.getY(), 50, 50);
        }
        repaint();
        }
        //    time=0;
    }





