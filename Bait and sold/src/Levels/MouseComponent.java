package Levels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MouseComponent extends JComponent
{ /*
    // instance variable
    private ArrayList<Point2D> CoorList; // Array to keep coordinate of all images
    private Point2D current;             // to represent the current image
    //  i.e., the image that we are just
    //  click..
    // constructor
    public MouseComponent()
    {
        CoorList = new ArrayList<Point2D>();  // instantiate it
        current = null;                       // no image yet.

        // to handle mouse click
        addMouseListener(new MouseHandler()); // we will implement
        //  a MouseHandler class below
        // to handle mouse move
        addMouseMotionListener(new MouseMotionHandler()); // we will implement
        // MouseMotionHandler
        // class below
    }

    public void paintComponent(Graphics g) // this will be called automatically
    {
        Image image = new ImageIcon("/home/parmcoder/gjbfish/JBproject/Bait and sold/src/unshi.jpg").getImage();
        // For each loop: go through all coordinates in the arraylist
        for (Point2D r : CoorList)
            g.drawImage(image, (int)r.getX(), (int)r.getY(), this);
    }

    public Point2D find(Point2D p)  // give a coordinate, it return a coordinate
    //   of the image if the input point is
    //   in the area of that image.
    //   It reutnrs null, if the input point
    //   is not in any image in the arraylist
    {
        for (Point2D r : CoorList)
        {
            // we have to check that is it in any image.
            // since we know that image size is 40 * 40, so we will check
            // in this range
            if (p.getX()>= r.getX() && p.getX()<=r.getX()+40 &&
                    p.getY()>= r.getY() && p.getY()<=r.getY()+40) {
                return r;
            }
        }
        return null;
    }

    // add that coordinate to the arraylist
    public void add(Point2D p)
    {
     /*   double x = p.getX();
        double y = p.getY(); */

     /*   current = p; // set current to this coordinate
        CoorList.add(current); // add the coordinate to the arraylist
        repaint(); // call repaint(), this will make Java call paintComponent
    }

    // remove the coordinate of a given point
/*    public void remove(Point2D s)
    {
        if (s == null) return; //return nothing
        if (s == current) current = null; // Has only current.
        CoorList.remove(s); //remove
        repaint();
    }

    // the square containing the mouse cursor
    public class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
            // add a new coordinate if the cursor isn't inside existing image
            current = find(event.getPoint());
            System.out.println(event.getButton());
            if (current == null) add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event)
        {
            // remove the current square if double clicked
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2) drop(current);
       //     System.out.println(current);
       //     System.out.println(CoorList);
        }
    }



    public class MouseMotionHandler implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
            // set the mouse cursor to cross hairs if it is inside
            // a image
            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event)
        {
            if (current != null)
            {
                int x = event.getX();
                int y = event.getY();

                current.setLocation(x, y);
                repaint();
            }
        }
    }

    class Animator implements Runnable {
        Point2D item;

        Animator(Point2D x) {
            item = x;
        }
        public void run(){ //dropping
            while(item.getY()<350-28){
                double x = item.getX();
                double y = item.getY()+1;
                //find the position of below picture
                double xright = x+41;
                double stopper = y+40;
                Point2D newitemL = new Point2D.Double(x,stopper); //coordinate below the left corner
                Point2D newitemR = new Point2D.Double(xright,stopper); //coordinate below the right corner
                if (find(newitemL) != null || find(newitemR) != null) break; //using find to check if it is null or not?
                item.setLocation(x, y);
                repaint();

                try{Thread.sleep(10);} catch(Exception e){}
            }
        }
    }

    public void drop(Point2D p){

        Animator anim = new Animator(p);
        Thread tOne = new Thread(anim);
        tOne.start();
    }
    */
}
