package Database;

import javax.swing.*;
import java.awt.*;

public class Datapanel extends JPanel {
    JLabel first = new JLabel("Best player");
    JLabel second = new JLabel("First runner-up");
    JLabel third = new JLabel("Second runner-up");

    JLabel number1 = new JLabel("Boi");
    JLabel number2 = new JLabel("Boi");
    JLabel number3 = new JLabel("Boi");

    ShowData data = new ShowData();

    public void adds() throws ClassNotFoundException {

        first.setBounds(550, 100, 500, 50);
        first.setFont(new Font("Arial", Font.PLAIN, 28));
        number1.setBounds(550, 140, 500, 50);
        number1.setFont(new Font("Arial", Font.PLAIN, 25));
        number1.setText(data.show(1));

        second.setBounds(200, 450, 500, 50);
        second.setFont(new Font("Arial", Font.PLAIN, 28));
        number2.setBounds(200, 490, 500, 50);
        number2.setFont(new Font("Arial", Font.PLAIN, 25));
        number2.setText(data.show(2));

        third.setBounds(900, 450, 500, 50);
        third.setFont(new Font("Arial", Font.PLAIN, 28));
        number3.setBounds(900, 490, 500, 50);
        number3.setFont(new Font("Arial", Font.PLAIN, 25));
        number3.setText(data.show(3));

        this.setBackground(Color.lightGray); //this is what will be added in the scoreboard
        this.setLayout(null);
        this.add(first);
        this.add(second);
        this.add(third);
        this.add(number1);
        this.add(number2);
        this.add(number3);
    }
}
