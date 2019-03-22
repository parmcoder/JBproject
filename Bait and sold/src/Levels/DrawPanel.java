package Levels;

import Fishes.EasyFish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {
 //   private int awidth;
//    private int aheight;

  //  private int red;
//    private int green;
//    private int blue;

    JButton fishtime = new JButton("Click to Bait");

    private ArrayList<EasyFish> fishlist = new ArrayList<>();

    public ArrayList<EasyFish> getFishlist(){
        return this.fishlist;
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(mgr);
    }

    public ArrayList<EasyFish> randomplace() {
        fishlist = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            int x = (int) (Math.random() * 1000);
            int y = (int) (Math.random() * 600);
            if (x > 900) {
                x -= 100;
            } else if (x < 80) {
                x += 100;
            }
            if (y > 520) {
                y -= 100;
            } else if (y < 80) {
                y += 100;
            }
            fishlist.add(new EasyFish(x, y));
        }

        for (int i = 0; i < 10; i++) {
            for (int j = i; j < (10 - i); i++) {
                if (fishlist.get(j).getFishx() == fishlist.get(j + 1).getFishx()) {
                    int newfishx = fishlist.get(j).getFishx();
                    fishlist.get(j).setFishx(newfishx += 100);

                }
            }
        }

        return fishlist;
    }

    public void go() {
        fishtime.setBounds(1000, 700, 200, 50);
        fishtime.addActionListener(new CreatorListener());
        this.add(fishtime);
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g); //needed since we're using JPanel extends
        setBackground(Color.DARK_GRAY);

        for (EasyFish fish : fishlist) {
            fish.paintComponent(g);
        }
    }

    class CreatorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // if{fishlis
            if (fishlist.size() == 0) {
                fishlist = randomplace();
                repaint();
            } else {
                System.out.println("Don't be greedy");
            }
        }

    }
}
    /*public void paint(Graphics g){
        fishtime.setBounds(500,500,100,50);
        this.add(fishtime);
    }*/


