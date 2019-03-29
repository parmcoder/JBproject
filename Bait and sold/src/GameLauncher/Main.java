package GameLauncher;


import Menu.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception
    {
        JFrame frame = new JFrame("Bait and Sold");
        Menu firstpane = new Menu(); //create menu panel
        frame.add(firstpane.menu()); //added to frame and we will stick to this frame forever
        frame.setSize(1280,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
