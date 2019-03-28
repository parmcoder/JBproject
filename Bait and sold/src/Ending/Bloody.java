package Ending;

import Sounds.SoundPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Bloody extends JPanel
{
    Image deadbg = new ImageIcon("Pic_lib/bad-end.jpg").getImage(); //I can use vicky's head instead...
    SoundPlayer bgm = new SoundPlayer("music_lib/drop.wav");
    JLabel notlikethis = new JLabel("GAME OVER");

    private List<Point2D> spillblood = new ArrayList<>();

    public void decorate()
    {
        this.setLayout(null);
        notlikethis.setBounds(400, 200, 800, 200);
        notlikethis.setFont(new Font("", Font.BOLD, 120));
        notlikethis.setForeground(Color.ORANGE);

        this.add(notlikethis);
        randomblood manydots = new randomblood();
        Thread a = new Thread(manydots);
        Thread b = new Thread(bgm);
        a.start();
        b.start();

    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
      //  super.paintComponent(g);
        g.drawImage(deadbg,0,0,this);
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
