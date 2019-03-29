package Menu;

import javax.swing.*;
import java.awt.*;

public class Bg extends JPanel {
    Image menubg = new ImageIcon("Pic_lib/menupic.jpg").getImage(); //I can use vicky's head instead...

    public void paintComponent(Graphics g){
        g.drawImage(menubg, 0,-20,null);
    }
}
