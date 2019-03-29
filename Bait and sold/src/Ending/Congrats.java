package Ending;

import Sounds.SoundPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

public class Congrats extends JPanel {
    //I just want to create good ending, it is similar to the bad ending
    private List<Point2D> spillcolor = new ArrayList<>();
    JLabel Yeah = new JLabel("Game over, well played");
    Image nicebg = new ImageIcon("Pic_lib/good-end.jpg").getImage();
    SoundPlayer bgm = new SoundPlayer("music_lib/goodend.wav");

    public void decorate()
    {
      this.setLayout(null);
      Yeah.setBounds(400, 200, 800, 200);
      Yeah.setFont(new Font("Arial", Font.BOLD, 60));
      this.add(Yeah);

      randomplace manydots = new randomplace();
      Thread a = new Thread(manydots);
      Thread b = new Thread(bgm);
      a.start();
      b.start();
    }


    public void paintComponent(Graphics g) // this will be called automatically
    {
        try{
        super.paintComponent(g);
        g.drawImage(nicebg,0,-60,null); //my background

        for (Point2D bloodpos : spillcolor) {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color randomColor = new Color(red, green, blue); //colorful colors generator
            g.setColor(randomColor);
            g.fillOval((int) bloodpos.getX(), (int) bloodpos.getY(), 75, 75);
        }
        }catch(
        ConcurrentModificationException e){}//make it good, make it colorful, I random colors
    }

    class randomplace implements Runnable{
        public void run()
        {
            while(true)
            {
                for (int i = 0; i < 20; i++) {
                    int x = (int) (Math.random() * 1280);
                    int y = (int) (Math.random() * 800);
                    spillcolor.add(new Point2D.Double(x, y)); //add spot randomly
                }
                try
                {
                    repaint();
                    Thread.sleep(200);
                }
                catch (InterruptedException e) { Thread.interrupted(); }
                finally {
                    spillcolor.removeAll(spillcolor);
                }
            }
        }

    }
}







