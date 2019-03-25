package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowData {
    private String name;
    private int money =0;
    private String nameandscore;
    private List<String> ranking = new ArrayList();


    public String show(int rank) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:sqlite:highscores.db");
            name = "None";
            //String getrank = "INSERT INTO highscore VALUES('"+name+"',"+ score+")";
            Statement statement = connection.createStatement();

            statement.setQueryTimeout(30);
            statement.executeUpdate("SELECT player_name, score FROM highscore ORDER BY score DESC");
            //statement.executeUpdate("CREATE TABLE highscore (player_name TEXT, score INTEGER )");

            ResultSet rs = statement.executeQuery("SELECT player_name, score FROM highscore ORDER BY score DESC");
            //for(int i = 0; ranking > i; i++)
            while(rs.next())
            {
            name = rs.getString("player_name");
            money = rs.getInt("score");
            nameandscore = String.format("%s and %d",name,money);
            ranking.add(nameandscore);
            }

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
        return ranking.get(rank-1);
    }
}
