package Levels;

import javax.swing.*;


public class TD implements Runnable
{
    private static int ballPosition = 0;
    private static Thread threadOne;
    private static Thread threadTwo;
    public String playerName;

    public static void main(String[] args) {
        TD playerOne = new TD();
        TD playerTwo = new TD();
        playerOne.playerName = "Tom";
        playerTwo.playerName = "James";

        threadOne = new Thread(playerOne);
        threadTwo = new Thread(playerTwo);

        threadOne.start();
        threadTwo.start();
    }

    public void run(){
        for(int i =0; i<10; i++){
            System.out.println("Thread of " + this.playerName);
            System.out.println("Ball position is " + ballPosition);

            if((ballPosition==0)&&(this.playerName.equals("Tom"))){
                System.out.println("Tom hits the ball.");
                ballPosition = 1;
            }else if((ballPosition==1)&&(this.playerName.equals("James"))){
                System.out.println("James hits the ball.");
                ballPosition = 0;
            }
            try{ Thread.sleep(100);} catch(Exception e){}
        }
    }
}