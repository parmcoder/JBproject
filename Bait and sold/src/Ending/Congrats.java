package Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Congrats extends JPanel {
    private List<Point2D> spillcolor = new ArrayList<>();
    JLabel Yeah = new JLabel("Game over, well played");

    public void decorate()
    {
      this.setLayout(null);
      Yeah.setBounds(300, 200, 800, 200);
      Yeah.setFont(new Font("Arial", Font.BOLD, 60));
      this.add(Yeah);

      randomplace manydots = new randomplace();
      Thread a = new Thread(manydots);
      a.start();
    }


    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        for (Point2D bloodpos : spillcolor) {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color randomColor = new Color(red, green, blue); //colorful colors generator
            g.setColor(randomColor);
            g.fillOval((int) bloodpos.getX(), (int) bloodpos.getY(), 75, 75);
        }
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







