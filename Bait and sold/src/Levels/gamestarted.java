package Levels;
import javax.swing.*;

public class gamestarted {

    DrawPanel gamedraw = new DrawPanel();
    JPanel test = new JPanel();
    GameMouseListener clicker = new GameMouseListener(gamedraw); //added mouselistener for this panel

    public JPanel getGamedraw(){ //trying JPanel
        gamedraw.addMouseListener(clicker);
        test = gamedraw.go();
        return test;
    }


}
