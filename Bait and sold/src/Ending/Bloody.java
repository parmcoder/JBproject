package Ending;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class Bloody extends JPanel {
    private List<Point2D> spillblood = new LinkedList<Point2D>();


    public List<Point2D> randomblood() {
        if(spillblood.size()<2000){
        for (int i = 0; i < 4; i++) {
            int x = (int) (Math.random() * 1280);
            int y = (int) (Math.random() * 800);

            spillblood.add(new Point2D.Double(x, y));
        }
       /* if(wait == 20){
            for (int i = 0; i < 11; i++) {
                int x = (int) (Math.random() * 1280);
                int y = (int) (Math.random() * 800);

                spillblood.add(new Point2D.Double(x, y));
            }
        }
        wait++;
*/      }
        return spillblood;
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        randomblood();

        for (Point2D bloodpos : spillblood) {
            g.setColor(Color.RED);
            g.fillOval((int)bloodpos.getX(), (int)bloodpos.getY(), 50, 50);

        }
        repaint();
    }
}
