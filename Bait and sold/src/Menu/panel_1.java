package Menu;

import Database.Datapanel;
import Levels.*;
import Sounds.SoundPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panel_1 extends JPanel{
        JPanel mainpane = new JPanel();
        JPanel gamepane = new JPanel();
        JPanel menupane = new bg();

        JButton newgame = new JButton("NEW GAME");
        JButton GotoMenu = new JButton( "Back to menu");
        JButton EndtoMenu = new JButton( "Continue?");
        JButton Endtest = new JButton("You lose");
        JButton Scoreboard = new JButton("Scoreboard");

        gamestarted gamepanel = new gamestarted();
        Datapanel topthree = new Datapanel();

       // JPanel loadpane = new JPanel();
      //  JPanel helppane = new JPanel();

        Container panestorage = mainpane; //remind that we need container to store panels but where--
        // it will show? mainpane!
        CardLayout cl = new CardLayout(); //layout for the panel to be switchable

        SoundPlayer bgmusic = new SoundPlayer("music_lib/gameost2.wav");
        Thread player = new Thread(bgmusic);

        public JPanel menu() throws Exception{
                player.start();
                panestorage.setLayout(cl); //set the layout of that container
                gamepane = gamepanel.getGamedraw(); //for some reasons, I need to call this method to build game pane

                panestorage.add(gamepane, "gamepane");
                panestorage.add(menupane, "menupane");
                panestorage.add(topthree, "topthree"); //add those panels you need from the menu

                cl.show(panestorage, "menupane"); //show this pane first

                GotoMenu.setBounds(1000, 700, 200, 50); //set location of the buttons

                //Endtest.setBounds(1000, 20, 200, 50);

           //     JButton help = new JButton("HELP");

                //button.setFont(new Font("Arial", Font.PLAIN, 40)); my future plan

                newgame.setFont(new Font("Arial", Font.PLAIN, 28));
                Scoreboard.setFont(new Font("Arial", Font.PLAIN, 28)); //set font inside buttons
            //    help.setFont(new Font("Arial", Font.PLAIN, 28));
                GotoMenu.setFont(new Font("Arial", Font.PLAIN, 28)); //set location of the buttons
                //Endtest.setFont(new Font("Arial", Font.PLAIN, 22));

                menupane.setLayout(new GridBagLayout()); //when you want to center things in the panel use grid bags
                //menupane.paintComponents(); //add something for BG


                newgame.addActionListener(new Showgamepane()); //to change panels mostly check below
                GotoMenu.addActionListener(new Showmenupane());
                EndtoMenu.addActionListener(new BackToMenu());
                Scoreboard.addActionListener(new Show_scoreboard());


                //  loadgame.addActionListener(new PanelListener1());
              //  help.addActionListener(new PanelListener1());

                // creates a constraints object
                GridBagConstraints c = new GridBagConstraints();

                c.insets = new Insets(3, 3, 3, 3); // insets for all components - margin
                c.gridx = 0; // column 0
                c.gridy = 1; // row 0
                c.ipadx = 300; // increases components width by 300 pixels (two sides)
                c.ipady = 80; // increases components height by 10 pixel
                menupane.add(Scoreboard, c); // constraints passed in

               // endingpane.add(EndtoMenu, c);

                c.ipadx = 300;
                c.gridy = 0; // row 2
                menupane.add(newgame, c);
             //   gamepane.add(EndtoMenu);

             //   c.ipadx = 380;
             //   c.gridy = 2; // row 3
            //    menupane.add(help, c);

                topthree.add(GotoMenu); //I added

                return mainpane;
        }

        class Showgamepane implements ActionListener
        {
                public void actionPerformed(ActionEvent event)
                {
                        cl.show(panestorage,"gamepane");
                        bgmusic.stop();
                        try {

                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
        }

        class Showmenupane implements ActionListener{
                public void actionPerformed(ActionEvent event)
                {
                        cl.show(panestorage,"menupane");
                }
        }

        class BackToMenu implements ActionListener
        {
                public void actionPerformed(ActionEvent event)
                {
                        cl.show(panestorage,"menupane");
                        //System.out.println("clicked");
                        newgame.setText("NEW GAME");
                        gamepane.removeAll();
                        gamepane.revalidate();
                        gamepane.repaint();
                }
        }

        class Show_scoreboard implements ActionListener
        {
                public void actionPerformed(ActionEvent event)
                {
                        cl.show(panestorage,"topthree");
                        try { topthree.adds();}
                        catch (ClassNotFoundException e) {e.printStackTrace();}
                }
        }
}