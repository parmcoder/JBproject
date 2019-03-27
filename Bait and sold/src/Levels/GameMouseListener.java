package Levels;

import Fishes.EasyFish;
import Fishes.SuperFish;

import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class GameMouseListener extends MouseAdapter {
    private DrawPanel workingpanel;
    private ArrayList<EasyFish> remover;
    private Point2D current;
    private EasyFish fishy;
    public MoveLeft m;
    private SuperFish SuperFish;

    public EasyFish find(Point2D onclick) { //we use this method to find fish, similar to find Point2D
        for (EasyFish showing : workingpanel.getFishlist()) {
            if (showing.getFishx()+50 >= onclick.getX() && showing.getFishx() <= onclick.getX() &&
                    showing.getFishy()+50 >= onclick.getY() && showing.getFishy() <= onclick.getY() ) {
                return showing; // give us back the fish
            }
        }
        return null; //there is no fish there right?
    }

    public GameMouseListener(DrawPanel p) { // trick to make it work for extends JPanel class
        super();
        this.workingpanel = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        remover = workingpanel.getFishlist(); //time to catch the fish and count to get score
        current = e.getPoint();
        EasyFish the_fish = find(current);
        if(the_fish != null){
            catching(the_fish);
            if(the_fish.isFishsuper()){workingpanel.money +=1000;}
            for(EasyFish f:remover){
                f.caught();
            }
            if(the_fish.isBuyable()){
                the_fish.setBought();
                workingpanel.money +=10;
            }
            workingpanel.label.setText(workingpanel.score+workingpanel.money);
            workingpanel.repaint();
            //remover.remove(the_fish);
        }
     //   System.out.println(e.getX() + "and" + e.getY() + current+ workingpanel.money);
        workingpanel.repaint();
    }

    //HERE ARE THE THREADS
    class MoveLeft implements Runnable {
        EasyFish fish;

        MoveLeft(EasyFish fishpivot){
            fish = fishpivot;
        }
        public synchronized void run() {
            fish.supercaught();
            while (fish.getFishx() >= 140) {
                int newx = fish.getFishx()-1;
                fish.setFishx(newx);
                workingpanel.repaint();
                if(fish==null){break;}
                if(workingpanel.Finish){Thread.interrupted();}

                try {Thread.sleep(8);} catch (Exception e) { }
            }

            if(fish.getFishy()>600 && fish.getFishx() < 155){
                workingpanel.getFishlist().remove(fish); //remove that fish\
                workingpanel.repaint();


            }
            //(fish == null){Thread.interrupted();}

        }
    }

    class MoveDown implements Runnable {
        EasyFish fish;
        int newy;

        MoveDown(EasyFish fishpivot){
            fish = fishpivot;
        }
        public synchronized void run() {
            while (fish.getFishy() <= 620) {
                if(fish.getFishx() == 139){
                    newy = fish.getFishy()+8;
                }
                else{ newy = fish.getFishy()+1;}
                fish.setFishy(newy);
                workingpanel.repaint();

                if(workingpanel.Finish){Thread.interrupted();}
                try {Thread.sleep(25);} catch (Exception e) { }
            }
            if(fish.getFishy()>600 && fish.getFishx() < 155){
                workingpanel.getFishlist().remove(fish); //remove that fish
                workingpanel.repaint();

            }
            //if(fish == null){Thread.interrupted();}

        }
    }

    public void catching(EasyFish f) {
            f.caught(f);
            if(f.equals(SuperFish)){workingpanel.money += 100;}
            MoveLeft animX = new MoveLeft(f);
            MoveDown animY = new MoveDown(f);
            Thread tOne = new Thread(animX);
            Thread tTwo = new Thread(animY);
            tOne.start();
            tTwo.start();

    }

}