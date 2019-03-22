package Menu;

import GameLauncher.*;
import Levels.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

public class panel_1 {
        JPanel mainpane = new JPanel();
        JPanel gamepane = new JPanel();
        JPanel menupane = new JPanel();

        gamestarted gamepanel = new gamestarted();

       // JPanel loadpane = new JPanel();
      //  JPanel helppane = new JPanel();

        Container panestorage = mainpane;

        CardLayout cl = new CardLayout();


        public JPanel menu() {

                panestorage.setLayout(cl);
                gamepane = gamepanel.getGamedraw();
                //gamepane.addMouseListener(clicker);
                gamepane.setBackground(Color.BLACK);

                panestorage.add(gamepane, "gamepane");
                panestorage.add(menupane, "menupane");

                cl.show(panestorage, "menupane");

                JButton newgame = new JButton("NEW GAME");
             //   JButton loadgame = new JButton("LOAD GAME");
           //     JButton help = new JButton("HELP");

                //button.setFont(new Font("Arial", Font.PLAIN, 40));

                newgame.setFont(new Font("Arial", Font.PLAIN, 28));
            //    loadgame.setFont(new Font("Arial", Font.PLAIN, 28));
            //    help.setFont(new Font("Arial", Font.PLAIN, 28));

                menupane.setLayout(new GridBagLayout());
                menupane.setBackground(Color.BLACK);

                newgame.addActionListener(new PanelListener1());

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

                c.ipadx = 280;
                c.gridy = 1; // row 2
             //   menupane.add(loadgame, c);

                c.ipadx = 380;
                c.gridy = 2; // row 3
            //    menupane.add(help, c);


                return mainpane;
        }

        class PanelListener1 implements ActionListener{
                public void actionPerformed(ActionEvent event){
                        cl.show(panestorage,"gamepane");
                        System.out.println("clicked");
                }
        }



}