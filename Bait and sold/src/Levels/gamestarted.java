package Levels;

import Fishes.EasyFish;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class gamestarted {

    DrawPanel gamedraw = new DrawPanel();
    //JPanel idle = new JPanel();
    //CardLayout layout = new CardLayout();
    //JButton action = new JButton("Click to Bait");
    /*public JPanel gamego(){
        idle.setLayout(layout);
        idle.add(BorderLayout.SOUTH, action);
        idle.add(BorderLayout.CENTER, gamedraw);

        return idle;
    }*/
    GameMouseListener clicker = new GameMouseListener(gamedraw); //added mouselistener for this panel

    public DrawPanel getGamedraw(){
        gamedraw.addMouseListener(clicker);
        gamedraw.setLayout(null);
        gamedraw.go();
        return gamedraw;
    }

}
