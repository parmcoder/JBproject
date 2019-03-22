package Levels;

import javax.swing.*;


public class TD
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        MouseComponent component = new MouseComponent();
        JPanel p1 = new JPanel();
        p1.add(component);
        frame.add(component);
        frame.setTitle("MouseTest");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}