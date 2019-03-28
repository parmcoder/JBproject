package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveData {
    private String name;
    private int score;

    public void save(String s, int money) throws ClassNotFoundException  //need the name and money
    {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:highscores.db"); //connected!
            name = s;
            score = money;
            String update = "INSERT INTO highscore VALUES('"+name+"',"+ score+")"; //statment is written in String
            //add data to database, but don't arrange it

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate(update); //use the String to execute

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}