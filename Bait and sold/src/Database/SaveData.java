package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveData {
    private String name;
    private int score;

    public void save(String s, int money) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:highscores.db");
            name = s;
            score = money;
            String update = "INSERT INTO highscore VALUES('"+name+"',"+ score+")";
            Statement statement = connection.createStatement();

            statement.setQueryTimeout(30);

            //statement.executeUpdate("DROP TABLE IF EXISTS highscore");
            //statement.executeUpdate("CREATE TABLE highscore (player_name TEXT, score INTEGER )");

            //System.out.println(update);
            statement.executeUpdate(update);

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