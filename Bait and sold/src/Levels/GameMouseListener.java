package Levels;

import Fishes.EasyFish;
import Sounds.SfxPlayer;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class GameMouseListener extends MouseAdapter
{
    private DrawPanel workingpanel; //Because we change what happened in the game panel
    private ArrayList<EasyFish> remover;
    private Point2D current; //

    public EasyFish find(Point2D onclick)
    { //we use this method to find fish, similar to find Point2D
        for (EasyFish showing : workingpanel.getFishlist()) {
            if (showing.getFishx()+50 >= onclick.getX() && showing.getFishx() <= onclick.getX() &&
                    showing.getFishy()+50 >= onclick.getY() && showing.getFishy() <= onclick.getY() ) {
                return showing; // give us back the fish on that location
            }
        }
        return null; //there is no fish there right?
    }

    public GameMouseListener(DrawPanel p)
    { // trick to make it work for extends JPanel class
        super();
        this.workingpanel = p;
        workingpanel.addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        remover = workingpanel.getFishlist(); //time to catch the fish and count to get score from game panel
        current = e.getPoint(); //this is point2D, we will deal with it
        EasyFish the_fish = find(current); // use that point to find fish

        if(the_fish != null)
        { //in case we have the fish
            for(EasyFish f:remover)
            {
                if(f.isFishsuper()){}
                else{f.caught(f);}
            }

            if(the_fish.isFishsuper()&&the_fish.isBuyable())
            { //first time you get that super fish
                the_fish.supercaught(the_fish);
                the_fish.setBought(); //spamming won't let you gain more money
                workingpanel.money +=1000;

            }

            catching(the_fish);//this will make the fish move to the bucket

            if(the_fish.isBuyable())
            {
                the_fish.setBought();
                workingpanel.money +=10;
            }
            workingpanel.label.setText(workingpanel.score+workingpanel.money);
            workingpanel.repaint();
        }
        workingpanel.repaint();
    }
    private class MouseMotionHandler implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

        }

        public void mouseMoved(MouseEvent event) {
            // set the mouse cursor to cross hairs if it is inside
            // a image
            if (find(event.getPoint()) == null) workingpanel.setCursor(Cursor.getDefaultCursor());
            else workingpanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }

    //HERE ARE THE THREADS
    class MoveLeft implements Runnable
    {
        EasyFish fish;

        MoveLeft(EasyFish fishpivot){
            fish = fishpivot;
        }
        public synchronized void run()
        {
            while (fish.getFishx() >= 140)
            {
                int newx = fish.getFishx()-1;
                fish.setFishx(newx);
                workingpanel.repaint();
                if(fish==null || workingpanel.Finish){Thread.interrupted();}

                try {Thread.sleep(8);} catch (Exception e) { }
            }
            if(fish.getFishy()>600 && fish.getFishx() < 155){
                workingpanel.getFishlist().remove(fish); //remove that fish\
                workingpanel.repaint();
            }
        }
    }

    class MoveDown implements Runnable
    {
        EasyFish fish;
        int newy;

        MoveDown(EasyFish fishpivot){
            fish = fishpivot;
        }
        public synchronized void run()
        {
            while(true){
            while (fish.getFishy() <= 620)
            {
                if(fish.getFishx() == 139){newy = fish.getFishy()+8;}
                else{ newy = fish.getFishy()+1;}
                fish.setFishy(newy);
                workingpanel.repaint();

                if(fish==null || workingpanel.Finish){Thread.interrupted();}
                try {Thread.sleep(25);} catch (Exception e) { }
            }


            if(fish.getFishy()>600 && fish.getFishx() < 155){
                workingpanel.getFishlist().remove(fish); //remove that fish
                workingpanel.repaint();
                break;
            }
            }
        }
    }

    public void catching(EasyFish f)
    {
            f.supercaught(f);
            MoveLeft animX = new MoveLeft(f);
            MoveDown animY = new MoveDown(f);
            Thread tOne = new Thread(animX);
            Thread tTwo = new Thread(animY);
            tOne.start();
            tTwo.start();
    }
}