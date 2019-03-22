package Ending;

import Menu.panel_1;

import javax.swing.*;

public class TD {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bait and sold");
        JPanel p1 = new JPanel();
        GameOver gg = new GameOver();
        //create menu panel
        //   gamestarted newgameclicked = new gamestarted();
        ; //start at menu, check menu packages

        p1 = gg.gameover();
        frame.add(p1);
        frame.setSize(1280,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
