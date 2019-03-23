package Levels;

import Fishes.EasyFish;

import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Timer;

public class GameMouseListener extends MouseAdapter {
    private DrawPanel workingpanel;
    private ArrayList<EasyFish> remover;
    private Point2D current;

    private GameAnimator animator = new GameAnimator(workingpanel, current);

    public GameMouseListener(DrawPanel p) { // trick to make it work for extends JPanel class
        super();
        this.workingpanel = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        remover = workingpanel.getFishlist(); //time to remove the dot and count to get score
        current = e.getPoint();
        EasyFish the_fish = find(current);
        System.out.println(e.getX() + "and" + e.getY() + current+ the_fish);

    }

    public EasyFish find(Point2D onclick) {
        for (EasyFish showing : workingpanel.getFishlist()) {
            if (showing.getFishx()+50 >= onclick.getX() && showing.getFishx() <= onclick.getX() &&
                    showing.getFishy()+50 >= onclick.getY() && showing.getFishy() <= onclick.getY() ) {
                System.out.println("Found");
                return showing;
            }
        }
        return null;
    }
}