package Levels;

import Fishes.EasyFish;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameAnimator implements Runnable {
    private List<EasyFish> fishlist = new LinkedList<EasyFish>();
    public void run(){


        try{Thread.sleep(1000);} catch(Exception e){}
    }


    public void drop(){

        GameAnimator anim = new GameAnimator();
        Thread tOne = new Thread(anim);
        tOne.start();
        }
}
