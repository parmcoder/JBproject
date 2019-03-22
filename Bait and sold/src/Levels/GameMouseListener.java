package Levels;

import Fishes.EasyFish;

import java.awt.event.*;
import java.util.ArrayList;

public class GameMouseListener extends MouseAdapter {
    private DrawPanel workingpanel;
    private ArrayList<EasyFish> remover;

    public GameMouseListener(DrawPanel p){ // trick to make it work for extends JPanel class
        super();
        this.workingpanel  = p;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        remover = workingpanel.getFishlist(); //time to remove the dot and count to get score

        System.out.println(e.getX()+"and"+e.getY());
    }

}
