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
    JButton SaveDB = new JButton("Quit Fishing");

    String score = "Money earned = ";
    int money = 0;

    JLabel label = new JLabel(score+money);

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
            int x = (int) (175+Math.random() * 1000);
            int y = (int) (Math.random() * 500);

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
        fishtime.setBounds(1000, 650, 200, 50);
        fishtime.addActionListener(new CreatorListener());
        label.setBounds(300, 650, 600, 80);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.CYAN);
        this.add(fishtime);
        this.add(label);
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g); //needed since we're using JPanel extends
        setBackground(Color.DARK_GRAY);

        Image image = new ImageIcon("Pic_lib/Bucket.png").getImage();// the bucket is 150*150 pixels
        g.drawImage(image, 100, 600, this);

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


