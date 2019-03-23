package Levels;

import Fishes.EasyFish;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class GameAnimator implements Runnable {
    private List<EasyFish> fishlist = new LinkedList<EasyFish>();
    private Point2D pivot;
    private DrawPanel drawhere;

    GameAnimator(DrawPanel p, Point2D a){
        pivot = a;
        drawhere = p;
    }
    public void run(){

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
            drawhere.repaint();


        try{Thread.sleep(100);} catch(Exception e){}
    }


    public void catching(DrawPanel p2, Point2D catcher){

        GameAnimator anim = new GameAnimator(p2, catcher);
        Thread tOne = new Thread(anim);
        tOne.start();
        }
}
