package Levels;

import Database.*;
import Ending.GameOver;
import Fishes.EasyFish;
import Fishes.SuperFish;
import Sounds.SfxPlayer;
import Sounds.SoundPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class DrawPanel extends JPanel {
    //my game runs like menu with buttons and sequences, game-->add to scoreboard --> ending and bad ending for lazies
    JPanel switcher = new JPanel();     //this will be the panel that it will show

    DrawPanel game = this; //this panel is game, so I use this as a variable

    Container editing = switcher;       //store in editing those panels
    CardLayout cl = new CardLayout();

    GameOver ending = new GameOver();   //the endings will be called later after the game ends
    JPanel badending = new JPanel();
    JPanel goodending = new JPanel();

    public SaveData saver = new SaveData();     //I want to save something, so I create this class
                                                //remember that database stay the same no matter
                                                //classes you create
    public int timer = 80; //time starts at 80
    int superspawn = 0;
    String timestring = "Time left : ";
    JLabel Time = new JLabel(timestring+timer+" seconds"); //trying to add timer that is not created from timer

    JButton fishtime = new JButton("Click to Bait"); //bait and catch them
    JButton SaveDB = new JButton("Save score");

    JTextField player = new JTextField("Your name");

    String score = "Money earned = ";
    int money = 0;
    //haha money talks, my game will use money to decide who is the richest

    JLabel label = new JLabel(score+money);
    //I wanna add this to show the score

    Image image = new ImageIcon("Pic_lib/Bucket.png").getImage();
    //I can use vicky's head instead... but a bucket can keep fishes inside better
    Image gamebg = new ImageIcon("Pic_lib/gamebg.jpg").getImage(); //Just nice looking background


    public Boolean Finish = false;
    //Boolean is good, when the condition is not set

    private ArrayList<EasyFish> fishlist = new ArrayList<>();
    // the panel need access to change the fish

    public ArrayList<EasyFish> getFishlist(){
        return this.fishlist;
    }
    //use this to get the fishes in the panel

    SoundPlayer bgm = new SoundPlayer("music_lib/gameost.wav");

    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(mgr);
    }

    public ArrayList<EasyFish> randomplace() //with random, the fishes will spawn separately, or together :)
    {
        fishlist = new ArrayList<>();

        for (int i = 0; i < 11; i++)
        {
            int x = (int) (175+Math.random() * 1000);
            int y = (int) (100+Math.random() * 400); //it will be created within this dimension

            fishlist.add(new EasyFish(x, y)); //yeah, the fish is added and will be drawn in the panel
        }

        if(superspawn>2)
        { //after the game goes on the more you can complete the objective super fish will spawn

            for (int i = 0; i < superspawn-1; i++) {
                int x = (int) (400 + Math.random() * 200);
                int y = 400;
                fishlist.add(new SuperFish(x, y)); //the super fish will be added
            }
        }
        return fishlist;

    }

    public JPanel go() //I use this to add things on my panel, since extending won't allow me to add anything
    {

        editing.setLayout(cl); // to store pane and ending pane
        editing.add(game, "thispane"); //this is the first scene

        cl.show(editing, "thispane"); //show that first scene

        game.setLayout(null); //on the game pane I want to edit things myself

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

        return switcher; //return that container, not this panel
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        super.paintComponent(g); //needed since we're using JPanel extends
        setBackground(Color.DARK_GRAY);

        game.add(fishtime);
        game.add(label);
        game.add(Time); //added components

        if(timer < 1){ //time's up
            Finish = true; //affect events and other loops, stopping them and interrupt
            game.removeim(); //bye image
            game.removeAll(); //remove all to get the clean panel
            fishlist.removeAll(fishlist);
            game.add(player); //textfield box is added to the panel
            game.add(SaveDB); //save score button is also added to the panel

        }else
            {
                g.drawImage(gamebg, 0,0, this);
                g.drawImage(image, 100, 600, this); //keep drawing bucket... don't wanna remove it
            }
        try
        {
        for (EasyFish fish : fishlist)
            {
            fish.paintComponent(g); //in the class, I have describe how will the fishes are drawn
            }
        }catch(ConcurrentModificationException e){}//ignore this exception, but we will have it, runtime error :P
    }

    private void removeim()
    {
        image = null;
    } //here is the method for removing it

    class GototheEndListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            bgm.stop();
            if(game.money > 110)
            {
                goodending = ending.gamewin();
                editing.add(goodending, "goodending"); //normally you will get this ending
                cl.show(editing, "goodending");
            }
            else
                {
                badending = ending.gameover(); //the badending is bad, you must play very bad to get this
                editing.add(badending, "badending");
                cl.show(editing, "badending");
                }

            try
            {
                saver.save(player.getText(), money); //save data to database with the name entered in JLabel
            }
            catch (ClassNotFoundException e) {e.printStackTrace();}
            System.out.println(player.getText()+money);
        }

    }

    class CreatorListener implements ActionListener
    {
        private int counter = 0;
        public void actionPerformed(ActionEvent event)
        {
            if(counter == 0)
            {
                countdown(); //You know that the timer must be able to countdown
                game.repaint();
                counter = 1; //prevent multiple countdown
            }
            if (fishlist.size() == 0)
            {
                SfxPlayer yeahsfx = new SfxPlayer("music_lib/Yeah.wav");
                Thread YEAH = new Thread(yeahsfx);
                YEAH.start();   //play yeah sound
                fishlist = randomplace();
                if(counter == 1){timer+=10;}
                superspawn++;   //condition for winning, clear and catch super fishes
                game.repaint();
            } else {
                SfxPlayer sfx = new SfxPlayer("music_lib/pew.wav");
                Thread Pew = new Thread(sfx);
                Pew.start();
                timer-=20;
                Time.setForeground(Color.RED);  //this is the penalty for greedy people who try to get more fishes
                //catch what you baited first or you will get PEW!
                 //Pew! you are greedy, got time deducted
                game.repaint();
            }
        }

    }

    class timerunner implements Runnable //this is the thread that will make the timer runs down
    {
        int centisec =0;
        public void run()
        {
            while(timer>0)
            {
                if(centisec==10) //I want the frame to repaint often, for better fps.
                {
                    timer-=1;
                    centisec=0;
                }
                Time.setForeground(Color.WHITE);
                Time.setText(timestring+timer+" seconds"); //need to set it again before repaint
                Toolkit.getDefaultToolkit().sync(); //I found that this will make SWING run smoothly
                repaint();
                centisec++;
                try {Thread.sleep(100);} catch (Exception e) { }
            }
        }
    }

    public void countdown()
    {
        timerunner cd = new timerunner();       //let's say that I use this to start timer
        Thread bgmthread = new Thread(bgm);     //also start the epic music in the background
        Thread timetoend = new Thread(cd);
        timetoend.start();
        bgmthread.start();  //start them all
    }
}

