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
    private EasyFish fishy;
    public MoveLeft m;

  //  private GameAnimator animator;

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
        remover = workingpanel.getFishlist(); //time to remove the dot and count to get score
        current = e.getPoint();
        EasyFish the_fish = find(current);
        if(the_fish != null){
            catching(the_fish);
            //remover.remove(the_fish);
        }
        System.out.println(e.getX() + "and" + e.getY() + current+ workingpanel.money);
        workingpanel.repaint();

    }

    //HERE ARE THE THREADS
    class MoveLeft implements Runnable {
        EasyFish fish;

        MoveLeft(EasyFish fishpivot){
            fish = fishpivot;
        }
        public void run() {
            while (fish.getFishx() >= 150) {
                int newx = fish.getFishx()-1;
                fish.setFishx(newx);
       /* while(item.getY()<350-28){
            double x = item.getX();
            double y = item.getY()+1;
            //find the position of below picture
            double xright = x+41;
            double stopper = y+40;
            Point2D newitemL = new Point2D.Double(x,stopper); //coordinate below the left corner
            Point2D newitemR = new Point2D.Double(xright,stopper); //coordinate below the right corner
            if (find(newitemL) != null || find(newitemR) != null) break; //using find to check if it is null or not?
            item.setLocation(x, y);*/
                workingpanel.repaint();

                try {Thread.sleep(10);} catch (Exception e) { }
            }
            fish.setFishy(620);
            try {Thread.sleep(30);} catch (Exception e) { }
            workingpanel.repaint();
            workingpanel.getFishlist().remove(fish); //remove that fish
            workingpanel.repaint();
        }
    }

    class MoveDown implements Runnable {
        EasyFish fish;


        MoveDown(EasyFish fishpivot){
            fish = fishpivot;
        }
        public void run() {
            while (fish.getFishy() <= 620) {

                int newy = fish.getFishy()+1;
                fish.setFishy(newy);
       /* while(item.getY()<350-28){
            double x = item.getX();
            double y = item.getY()+1;
            //find the position of below picture
            double xright = x+41;
            double stopper = y+40;
            Point2D newitemL = new Point2D.Double(x,stopper); //coordinate below the left corner
            Point2D newitemR = new Point2D.Double(xright,stopper); //coordinate below the right corner
            if (find(newitemL) != null || find(newitemR) != null) break; //using find to check if it is null or not?
            item.setLocation(x, y);*/
                workingpanel.repaint();

                try {Thread.sleep(10);} catch (Exception e) { }
            }
            if(fish.getFishy()==620){
                System.out.println("Gotcha");
                workingpanel.money +=100;
                workingpanel.label.setText(workingpanel.score+workingpanel.money);
            }

        }
    }


          //  workingpanel.label.setText(workingpanel.score+workingpanel.money);
    public void catching(EasyFish f) {

            MoveLeft animX = new MoveLeft(f);
            MoveDown animY = new MoveDown(f);
            Thread tOne = new Thread(animX);
            Thread tTwo = new Thread(animY);
            tOne.start();
            tTwo.start();
    }

}

