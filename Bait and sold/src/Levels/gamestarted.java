package Levels;
import javax.swing.*;

public class gamestarted {

    DrawPanel gamedraw = new DrawPanel();
    JPanel test = new JPanel();
    GameMouseListener clicker = new GameMouseListener(gamedraw); //added mouselistener for gamedraw
    //I use the method to set panel to game panel

    public JPanel getGamedraw(){
        gamedraw.addMouseListener(clicker); //actions come from the mouse listener
        test = gamedraw.go();
        return test;
    }
}
