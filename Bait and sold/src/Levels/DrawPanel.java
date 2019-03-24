package Levels;

import Database.Datapanel;
import Ending.GameOver;
import Fishes.EasyFish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    JPanel switcher = new JPanel();

    DrawPanel game = this;

    Container editing = switcher; //try to make this changable
    CardLayout cl = new CardLayout();

    GameOver ending = new GameOver();
    JPanel badending = ending.gameover();
    JPanel goodending = ending.gamewin();

  //  Datapanel savescore = new Datapanel();
  //  JPanel data = sa

    public int timer = 80;
    public int endcounter = 0;
    String timestring = "Time left : ";
    JLabel Time = new JLabel(timestring+timer+" seconds");

    JButton fishtime = new JButton("Click to Bait");
    JButton SaveDB = new JButton("Save score");

    JTextField player = new JTextField("Your name");

    String score = "Money earned = ";
    int money = 0;
   // public int timer = 80;

    JLabel label = new JLabel(score+money);
  //  JLabel Time = new JLabel(timestring+timer+" seconds");

    Image image = new ImageIcon("Pic_lib/Bucket.png").getImage();

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

    public JPanel go() {

        editing.setLayout(cl);
        editing.add(game, "thispane");
        editing.add(badending, "badending");
        editing.add(goodending, "goodending");

        cl.show(editing, "thispane");

        game.setLayout(null);

        fishtime.setBounds(1000, 650, 200, 50);
        fishtime.addActionListener(new CreatorListener());

        label.setBounds(300, 650, 600, 80);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.CYAN);

        Time.setBounds(10, 20, 600, 40); //move button to gamepane to end the game
        Time.setFont(new Font("Arial", Font.PLAIN, 20));
        Time.setForeground(Color.WHITE);

        SaveDB.setBounds(480, 400, 400, 50);
        SaveDB.setFont(new Font("Arial", Font.PLAIN, 20));
        SaveDB.addActionListener(new GototheEndListener());

        player.setBounds(480, 300, 400, 50);
        player.setFont(new Font("Arial", Font.PLAIN, 16));

        return switcher;
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g); //needed since we're using JPanel extends
        setBackground(Color.DARK_GRAY);
        game.add(fishtime);
        game.add(label);
        game.add(Time);
        g.drawImage(image, 100, 600, this);
        if(timer < 1){
            game.removeim();
            game.removeAll();
            fishlist.removeAll(fishlist);
            game.add(player);
            game.add(SaveDB);
            repaint();
        }
        for (EasyFish fish : fishlist) {
            fish.paintComponent(g);
        }
    }

    private void removeim() {
        image = null;
    }

    class GototheEndListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // if{fishlis
            if(game.money > 10){
            cl.show(editing, "goodending");}
            else{cl.show(editing, "badending");}

            System.out.println(player.getText()+money);
        }

    }

    class CreatorListener implements ActionListener {
        private int counter = 0;
        public void actionPerformed(ActionEvent event) {
            // if{fishlis
            if(counter == 0){
                countdown();
                game.repaint();
                counter = 1;
            }
            if (fishlist.size() == 0) {
                fishlist = randomplace();
                if(counter > 2){
                timer+=10;}
                counter++;
                game.repaint();
            } else {
                timer-=12;
            }
        }

    }

    class timerunner implements Runnable{
        public void run(){
            while(timer>0){
            timer-=1;
            Time.setText(timestring+timer+" seconds");
            repaint();
            try {Thread.sleep(1000);} catch (Exception e) { }
            }
        }
    }

    public void countdown(){
        timerunner cd = new timerunner();
        Thread timetoend = new Thread(cd);
        timetoend.start();
    }
}

