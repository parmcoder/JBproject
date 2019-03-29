package Database;

import javax.swing.*;
import java.awt.*;

public class Datapanel extends JPanel {
    JLabel first = new JLabel("Best player");
    JLabel second = new JLabel("First runner-up");
    JLabel third = new JLabel("Second runner-up");

    JLabel firstmoney = new JLabel();
    JLabel secondmoney = new JLabel();
    JLabel thirdmoney = new JLabel();

    JLabel number1 = new JLabel();
    JLabel number2 = new JLabel();
    JLabel number3 = new JLabel();

    ShowData data = new ShowData();

    Image highscorebg = new ImageIcon("Pic_lib/highscore.jpg").getImage(); //I can use vicky's head instead...


    public void adds() throws ClassNotFoundException {

        first.setBounds(550, 110, 500, 50);         //You don't need to read all these line
        first.setFont(new Font("Arial", Font.PLAIN, 28));//Because I only want to set up a layout
        number1.setBounds(550, 140, 500, 60);
        number1.setFont(new Font("Arial", Font.PLAIN, 22));
        number1.setText(data.showname(1));                      //!!!! THIS IS IMPORTANT CHECK SHOWDATA
        firstmoney.setBounds(550, 160, 500, 60);
        firstmoney.setFont(new Font("Arial", Font.PLAIN, 22));
        firstmoney.setText("Earned "+data.showmoney(1));        //!!!! THIS IS IMPORTANT CHECK SAVEDATA


        second.setBounds(200, 480, 500, 60);
        second.setFont(new Font("Arial", Font.PLAIN, 26));
        number2.setBounds(200, 510, 500, 60);
        number2.setFont(new Font("Arial", Font.PLAIN, 20));
        number2.setText(data.showname(2));
        secondmoney.setBounds(200, 530, 500, 60);
        secondmoney.setFont(new Font("Arial", Font.PLAIN, 22));
        secondmoney.setText("Earned "+data.showmoney(2));

        third.setBounds(900, 480, 500, 50);
        third.setFont(new Font("Arial", Font.PLAIN, 26));
        number3.setBounds(900, 510, 500, 60);
        number3.setFont(new Font("Arial", Font.PLAIN, 20));
        number3.setText(data.showname(3));
        thirdmoney.setBounds(900, 530, 500, 60);
        thirdmoney.setFont(new Font("Arial", Font.PLAIN, 22));
        thirdmoney.setText("Earned "+data.showmoney(3));

        this.setBackground(Color.lightGray); //this is what will be added in the scoreboard
        this.setLayout(null);
        this.add(first);
        this.add(second);
        this.add(third);
        this.add(number1);
        this.add(number2);
        this.add(number3);
        this.add(firstmoney);
        this.add(secondmoney);
        this.add(thirdmoney);

    }
    public void paintComponent(Graphics g){
        g.drawImage(highscorebg,0,0,this);
    } //my Background
}
