package GameLauncher;

import Menu.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bait and sold");
        JPanel p1 = new JPanel();

        panel_1 firstpane = new panel_1();
         //create menu panel
     //   gamestarted newgameclicked = new gamestarted();
        ; //start at menu, check menu packages

        p1 = firstpane.menu();
        frame.add(p1);
        frame.setSize(1280,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
