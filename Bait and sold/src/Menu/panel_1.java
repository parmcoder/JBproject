package Menu;

import Ending.Bloody;
import Ending.GameOver;
import GameLauncher.*;
import Levels.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

public class panel_1{
        JPanel mainpane = new JPanel();
        JPanel gamepane = new JPanel();
        JPanel menupane = new JPanel();

        //using this for ending

        JButton newgame = new JButton("NEW GAME");
        JButton GotoMenu = new JButton( "Back to menu");
        JButton EndtoMenu = new JButton( "Continue?");
        JButton Endtest = new JButton("You lose");


        gamestarted gamepanel = new gamestarted();

       // JPanel loadpane = new JPanel();
      //  JPanel helppane = new JPanel();

        Container panestorage = mainpane;
        CardLayout cl = new CardLayout();


        public JPanel menu() {

                panestorage.setLayout(cl);
                gamepane = gamepanel.getGamedraw();
                //gamepane.addMouseListener(clicker);

                panestorage.add(gamepane, "gamepane");
                panestorage.add(menupane, "menupane");

                cl.show(panestorage, "menupane");
                GotoMenu.setBounds(1000, 700, 200, 50);

                Endtest.setBounds(1000, 20, 200, 50);
                Endtest.setFont(new Font("Arial", Font.PLAIN, 22));

                //   JButton loadgame = new JButton("LOAD GAME");
           //     JButton help = new JButton("HELP");

                //button.setFont(new Font("Arial", Font.PLAIN, 40));

                newgame.setFont(new Font("Arial", Font.PLAIN, 28));
            //    loadgame.setFont(new Font("Arial", Font.PLAIN, 28));
            //    help.setFont(new Font("Arial", Font.PLAIN, 28));

                menupane.setLayout(new GridBagLayout());
                menupane.setBackground(Color.BLACK);


                newgame.addActionListener(new PanelListener1());
                GotoMenu.addActionListener(new PanelListener2());
                EndtoMenu.addActionListener(new PanelListener3());


                //  loadgame.addActionListener(new PanelListener1());
              //  help.addActionListener(new PanelListener1());

                // creates a constraints object
                GridBagConstraints c = new GridBagConstraints();

                c.insets = new Insets(3, 3, 3, 3); // insets for all components - margin
                c.gridx = 0; // column 0
                c.gridy = 0; // row 0
                c.ipadx = 290; // increases components width by 10 pixels (two sides)
                c.ipady = 60; // increases components height by 10 pixel
                menupane.add(newgame, c); // constraints passed in

               // endingpane.add(EndtoMenu, c);

                c.ipadx = 280;
                c.gridy = 1; // row 2
             //   menupane.add(loadgame, c);

                c.ipadx = 380;
                c.gridy = 2; // row 3
            //    menupane.add(help, c);

                gamepane.add(GotoMenu);

                return mainpane;
        }

        class PanelListener1 implements ActionListener{
                public void actionPerformed(ActionEvent event){
                        cl.show(panestorage,"gamepane");
                        System.out.println("clicked");

                }
        }

        class PanelListener2 implements ActionListener{
                public void actionPerformed(ActionEvent event){
                        cl.show(panestorage,"menupane");
                        System.out.println("clicked");
                        newgame.setText("CONTINUE");
                }
        }

        class PanelListener3 implements ActionListener{
                public void actionPerformed(ActionEvent event){
                        cl.show(panestorage,"menupane");
                        System.out.println("clicked");
                        newgame.setText("NEW GAME");
                        gamepane.removeAll();
                        gamepane.revalidate();
                        gamepane.repaint();

                }
        }






}