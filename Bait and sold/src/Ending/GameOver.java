package Ending;


import javax.swing.*;
import java.awt.*;

public class GameOver {

    Bloody gameover = new Bloody();
    Congrats winner = new Congrats();
    //JPanel shitty = new JPanel();
 //   JButton exit_game = new JButton("exit game");
    public Bloody gameover(){
        gameover.decorate();

        return gameover;
    }
    public Congrats gamewin(){
        winner.decorate();
        return winner;
    }
}
